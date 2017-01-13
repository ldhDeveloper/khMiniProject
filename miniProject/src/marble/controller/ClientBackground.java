package marble.controller;

import java.io.*;

import java.net.*;
import java.util.Scanner;

import marble.view.*;

public class ClientBackground implements Serializable {

	transient private Socket socket;
	transient private ObjectOutputStream oos;
	transient private ObjectInputStream ois;
	private PageGame gui;
	private MainFrame m;
	private PageLogIn p;
	private String msg;
	private int buttonResult = 8;
	private byte result = 30;
	private String ChatMsg;
	private String name;

	public ClientBackground() throws UnknownHostException, IOException {
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		//oos_receicer = new ObjectOutputStream(socket.getOutputStream());;
		System.out.println("ClientBackground");
	}

	public void setGui(PageGame gui) {
		this.gui = gui;
	}

	public PageGame getGui() {
		return gui;
	}

	public void recordTry(String log) throws IOException {
		oos.writeByte(10);
		oos.writeUTF(log);
		oos.flush();
	}

	public void loginTry(String log) throws IOException {
		oos.writeByte(20);
		oos.writeUTF(log);
		oos.flush();
	}

	public void connet() {
		
		try {
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
			if (socket.isConnected())
				System.out.println("서버 연결됨. (" + socket + ")");
			m.represent();
			
			PageGame pageGame = (PageGame)m.getPan3();
			//PageGame pageGame = new PageGame();
			
			 PrintWriter pw = new PrintWriter(oos);
			boolean flag = true;
			while (flag) { // 서버와 신호에 따른 결과값 중계
				System.out.println("중복");
				result = ois.readByte();
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
					setButtonResult(1);
					oos.writeByte(30);
					oos.flush();
					int order = 0; // 게임 페이지에 기록될 순번과 이름
					String queue = "";
					//ois_receicer = new ObjectInputStream(socket.getInputStream());
					queue = ois.readUTF();
					
					System.out.println("queue : " + queue);
					String[] orderAndName = queue.split(" ");
					order = Integer.parseInt(orderAndName[0]);
					System.out.println("order : " + order);

					switch (order) {// 아이디 위치 플레이 순서 배정
					case 1:
						/*
						pageGame.getUser1Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser1Money().setText("400000");
						*/
						oos.writeObject(pageGame);
						oos.flush();
						pageGame =(PageGame)ois.readObject();
						break;
					case 2:
						pageGame.getUser2Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser2Money().setText("400000");
						oos.writeObject(pageGame);
						oos.flush();
						break;
					case 3:
						pageGame.getUser3Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser3Money().setText("400000");
						oos.writeObject(pageGame);
						oos.flush();
						break;
					case 4:
						pageGame.getUser4Info().setText("<html>ID : " + orderAndName[1] + "<br>자산 :");
						pageGame.getUser4Money().setText("400000");
						oos.writeObject(pageGame);
						oos.flush();
						break;
					}

					
					setGui(pageGame);
					m.getCardLayout().show(m.getContentPane(), "game");
					
					System.out.println("입장성공");
					flag = false;
				}
			}
			while (true) {
				int endTurn =0;
				System.out.println("시작");
				byte turn = 0;// 현재 값 읽기 불가 오류발생
				turn = ois.readByte();
				System.out.println(turn);
				byte result =0;
				switch (turn) {// 순서에 의한 주사위 버튼의 사용조건 설정

				case 100: //현재 객체값 읽어들이는 순서도만 적용 세부내용 구체화 필요
					pageGame = (PageGame) ois.readObject();
					oos.writeByte(1);
					setGui(pageGame);
					pageGame.setController((MarbleController) ois.readObject());
					oos.writeByte(1);
					break;
				case 110:
					pageGame.getBtn1().setEnabled(true);
					endTurn = ois.readInt();
					endTurn =0;
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

	public void sendSignal(byte sign) {
		try {
			oos.writeByte(sign);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			oos.writeUTF(msg);
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