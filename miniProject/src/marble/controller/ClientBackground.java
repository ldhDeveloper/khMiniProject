package marble.controller;

import java.io.*;
import java.net.*;

import marble.view.PageGame;

public class ClientBackground {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private PageGame gui;
	private String msg;
    private String nickName;
	
	public void setGui(PageGame gui) {
		this.gui = gui;
	}
	
	public void connet() {
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			System.out.println("서버 연결됨.");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName);
			System.out.println("메시지 전송완료");
			while(in != null){
				msg=in.readUTF();
				gui.appendMsg(msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connet();
    }
 
    public void sendMessage(String msg2) {
        try {
            out.writeUTF(msg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void setNickname(String nickName) {
        this.nickName = nickName;
    }
	
}
