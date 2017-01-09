package marble.controller;

import java.io.*;

import java.net.*;

import marble.view.*;

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

	public int recording(MainFrame m) {
		int result = 0;
		PageJoin record = new PageJoin(m);
		System.out.println(record.getTfID());
		if (record.getTfPWD1().getText().equals(record.getTfPWD2().getText())) {
			try {
				socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
				System.out.println("서버 연결됨.");
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				out.writeUTF("회원가입 실행"); //서버에 회원가입 실행하라는 메세지

				out.writeUTF(record.getTfID().getText() + " " + record.getTfPWD1().getText());
				result = in.readInt();
				out.writeInt(1);//서버 닫는 값
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int login(MainFrame m) {
		int result = 1;
		try {
			PageJoin record = new PageJoin(m);
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			System.out.println("서버 연결됨.");
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF("로그인 실행");//서버에 로그인 실행하라는 메세지
			out.writeUTF(record.getTfID().getText() + " " + record.getTfPWD1().getText());
			result = in.readInt();
			out.writeInt(result);
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		return result;
	}

	public void connet() {
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			System.out.println("서버 연결됨.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF(nickName);
			System.out.println("메시지 전송완료");
			while (in != null) {
				msg = in.readUTF();
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
