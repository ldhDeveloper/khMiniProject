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
	

	public void setGui(PageGame gui) {
		this.gui = gui;
	}

	public void recordTry(String log) throws IOException{
		out.writeByte(0010);
		out.writeUTF(log);
	}
	public int recordResult() throws IOException{
		int result = 0;
		Byte bResult = in.readByte();
		switch(bResult){
		case 1: result =0; break;
		case 2: result =1; break;
		}
		return result;
	}
	public void loginTry(String log) throws IOException{
		out.writeByte(0020);
		out.writeUTF(log);
	}
	public int loginResult() throws IOException{
		int result = 0;
		Byte bResult = in.readByte();
		switch(bResult){
		case 1: result =0; break;
		case 2: result =1; break;
		}
		return result;
		
	}
	
	public ClientBackground() throws UnknownHostException, IOException{
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
		
	}
	public void connet() {
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			System.out.println("서버 연결됨.");
			m=new MainFrame();
			m.represent();
			while(true){
				byte result =in.readByte();
				switch(result){
				case 0011 :  break;
				case 0021 : break;
				case 0031 : 
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);
			}
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}

