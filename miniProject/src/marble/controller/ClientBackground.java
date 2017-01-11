package marble.controller;

import java.io.*;

import java.net.*;
import java.util.Scanner;

import marble.view.*;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private PageGame gui;
	private MainFrame m;
	private PageLogIn p;
	private String msg;
	private int buttonResult = 8;
	private byte result = 30;
	
	public void setGui(PageGame gui) {
		this.gui = gui;
	}

	public void recordTry(String log) throws IOException {
		out.writeByte(0010);
		out.writeUTF(log);
	}

	public void loginTry(String log) throws IOException {
		out.writeByte(0020);
		out.writeUTF(log);
	}
	

	public ClientBackground() throws UnknownHostException, IOException {
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());

	}

	public void connet() {
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			if (socket.isConnected())
				System.out.println("서버 연결됨. (" + socket + ")");
			
			m.represent();
			
			/*
			while(true) {
				System.out.println("전송할 메세지 : ");
				String message = new Scanner(System.in).nextLine();
				out.writeUTF(message);
				out.flush();
			*/
			while (true) {
				
				result = in.readByte();
				System.out.println((result!=30)?("result : " + result):"");
				
				switch (result) {
				case (byte)11: 
					setButtonResult(0); 
					break;
				case (byte)21:
					System.out.println(result);
					setButtonResult(1);
					break;
				case 0031: 	
					m.getCardLayout().show(m.getContentPane(), "game");
					System.out.println("입장성공");
					while (in != null) {
						msg = in.readUTF();
						gui.appendMsg(msg);
					}
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
