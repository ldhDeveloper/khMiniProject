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
	private String ChatMsg;
	private String name;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public void setGui(PageGame gui) {
		this.gui = gui;
	}

	public PageGame getGui() {
		return gui;
	}

	public void recordTry(String log) throws IOException {
		out.writeByte(10);
		out.writeUTF(log);
	}

	public void loginTry(String log) throws IOException {
		out.writeByte(20);
		out.writeUTF(log);
	}

	public ClientBackground() throws UnknownHostException, IOException {
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
		setOis(new ObjectInputStream(socket.getInputStream()));
		setOos(new ObjectOutputStream(socket.getOutputStream()));

	}

	public void connet() {
		PageGame pageGame = ((PageGame) m.getPan3());
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			if (socket.isConnected())
				System.out.println("서버 연결됨. (" + socket + ")");

			m.represent();

			PrintWriter pw = new PrintWriter(out);
			boolean flag = true;
			while (flag) { // 서버와 신호에 따른 결과값 중계
				System.out.println("중복");
				result = in.readByte();
				System.out.println((result != 30) ? ("result : " + result) : "");

				switch (result) {
				case (byte) 11:
					System.out.println("해당 회원정보 존재하지 X");
					setButtonResult(0);
					break;
				case (byte) 21:
					System.out.println(result);
					setButtonResult(1);
					break;
				case (byte) 31:
					out.writeByte(30);
					int order = 0; // 게임 페이지에 기록될 순번과 이름
					String queue = "";
					try {
						Thread.sleep(200l);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					queue = in.readUTF();
					String[] orderAndName = queue.split(" ");
					order = Integer.parseInt(orderAndName[0]);

					switch (order) {// 아이디 위치 플레이 순서 배정
					case 1:
						pageGame.getUser1Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser1Money().setText("400000");
						break;
					case 2:
						pageGame.getUser2Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser2Money().setText("400000");
						break;
					case 3:
						pageGame.getUser3Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser3Money().setText("400000");
						break;
					case 4:
						pageGame.getUser4Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser4Money().setText("400000");
						break;
					}
					setGui((PageGame) (m.getPan3()));
					m.getCardLayout().show(m.getContentPane(), "game");
					System.out.println("입장성공");
					flag = false;
				}
			}
			while (true) {
				System.out.println("시작");
				byte turn = 0;// 현재 값 읽기 불가 오류발생
				turn = in.readByte();
				System.out.println(turn);
				switch (turn) {// 순서에 의한 주사위 버튼의 사용조건 설정

				case 100: //현재 객체값 읽어들이는 순서도만 적용 세부내용 구체화 필요
					pageGame.getBtn1().setEnabled(false);
					pageGame = (PageGame) ois.readObject();
					setGui(pageGame);
					pageGame.setController((MarbleController) ois.readObject());
					break;
				case 110:
					pageGame.getBtn1().setEnabled(true);
					break;
				}
				System.out.println("실패");

			}

			/*
			 * while (true) { msg = in.readUTF(); gui.appendMsg(msg+"\n");
			 * System.out.println(msg); if ((ChatMsg = gui.getChatMsg()) != null
			 * && ChatMsg != "") { pw.println(ChatMsg); //out.writeUTF(ChatMsg);
			 * } }
			 */
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendSignial(byte sign) {
		try {
			out.writeByte(sign);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
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

	public void getName(String name) {
		this.name = name;
	}

	public DataInputStream getIn() {
		return in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
}