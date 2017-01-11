package marble.controller;

import java.io.*;

import java.net.*;

import marble.view.*;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private PageGame gui;
	private MainFrame m;
	private PageLogIn p;
	private String msg;
	private int buttonResult;

	public void setGui(PageGame gui) {
		this.gui = gui;
	}

	public void recordTry(String log) throws IOException {
		out.writeByte(10);
		out.flush();
		out.writeUTF(log);
		out.flush();
	}

	public void loginTry(String log) throws IOException {
		out.writeByte(20);
		out.writeUTF(log);
	}

	public ClientBackground() throws UnknownHostException, IOException {
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());

	}

	public void connet() {
		
			System.out.println("서버 연결됨.");
			sendMessage(" A guest entered!");
			m.represent();
			Thread th = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						while (true) {
							byte result = in.readByte();
							switch (result) {
							case 11: System.out.println("결과 받고");
								setButtonResult(0);
								break;
							case 21:  System.out.println("결과 받고");
								setButtonResult(1);
								break;
							case 31:
								m.getCardLayout().show(m.getContentPane(), "game");
								System.out.println("입장성공");
								while (in != null) {
									msg = in.readUTF();
									gui.appendMsg(msg);
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			th.start();
		
	}

	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MainFrame getM() {
		return m;
	}

	public void setM(MainFrame m) {
		this.m = m;
	}

	public int getButtonResult() {
		return buttonResult;
	}

	public void setButtonResult(int buttonResult) {
		this.buttonResult = buttonResult;
	}

}
