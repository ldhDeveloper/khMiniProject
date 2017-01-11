package marble.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import marble.model.Member;
import marble.run.ServerGui;
import marble.view.*;
import java.util.*;

//입장부터 네트워크화
public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	byte choice;
	private String msg;
	private Map<String, Member> info;
	private Member[] players;
	private Map<String, DataOutputStream> clientsMap;
	private Map<String, DataOutputStream> guest;
	private String IDkey;
	private Member member;
	private Vector guestList = new Vector();

	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public ServerBackground() {
		clientsMap = new HashMap<String, DataOutputStream>();
		guest = new HashMap<String, DataOutputStream>();

		Collections.synchronizedMap(guest);
		Collections.synchronizedMap(clientsMap);

	}

	public void connectionSignal() throws IOException {// 서버소켓연결실행

		serverSocket = null;

		try {

			serverSocket = new ServerSocket(5000);
			gui.appendMsg("서버 구동완료 " + "\n");

			connection();

		} catch (Exception e) {
		}
	}

	public void connection() { // 스트림 연결과 벡터에 스레드 담기 그 후 서버 가동
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {

				while (true) {
					try {
						gui.appendMsg("게스트입장 대기중\n");
						socket = serverSocket.accept();
						gui.appendMsg("게스트 접속\n");
						Receiver receiver = new Receiver(socket, guestList);
						guestList.add(receiver);// 해당 백터에 사용자 객체 추가
						receiver.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		th.start();

	}

	public static void main(String[] args) throws IOException {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.connectionSignal();
	}

	public void addClient(String nick, DataOutputStream out) throws IOException {
		sendMessage(nick + "님이 접속하셨습니다.\n");
		clientsMap.put(nick, out);
	}

	public void addGuest(String nick, DataOutputStream out) throws IOException {
		sendMessage(nick + "입장");
		guest.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "님이 나가셨습니다.\n");
		clientsMap.remove(nick);
	}

	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Receiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;
		private Vector guestList;

		public Receiver(Socket socket, Vector guest) {
			this.socket = socket;
			this.guestList = guest;
			networkBinding();

		}

		public void networkBinding() {// 스트림연결
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

			} catch (Exception e) {
				System.out.println("스트림 셋팅 에러");
			}
		}

		public void recordConfirm(String person) {// 파일에 회원정보 기록
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))) {
				info = (HashMap) ois.readObject();

				if (!info.containsKey(person)) {
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {
						String[] contain = person.split(" ");
						member = new Member(contain[0], contain[1]);
						info.put(contain[0], member);
						oos.writeObject(info);
						oos.flush();
						out.writeByte(0021);
					} catch (Exception e2) {
					}
				} else
					out.writeByte(0011);
			} catch (Exception e) {
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {
					String[] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info.put(contain[0], member);
					oos.writeObject(info);
					oos.flush();
					out.writeByte(0021);
				} catch (Exception e3) {
				}
			}
		}

		public void logConfirm(String name) {// 파일의 회원 정보 로그인시 확인
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))) {
				info = (HashMap) ois.readObject();
				name = in.readUTF();
				String[] teared = name.split(" ");
				if (info.containsKey(teared[0])) {
					if (((Member) info.get(teared[0])).getPassword().equals(teared[1])) {
						out.writeByte(0031);
						IDkey = teared[0];
					}
				} else
					out.writeByte(0011);

			} catch (Exception e) {

			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {

			try {

				while (true) {
					byte choice = in.readByte();
					String log = "";

					switch (choice) {
					case 10:
						log = in.readUTF();
						recordConfirm(log);
						break;
					case 20:
						log = in.readUTF();
						String[] confirm = log.split(" ");
						logConfirm(confirm[0]);
						break;
					case 30:
						addClient(IDkey, out);
						while (in != null) {

							msg = in.readUTF();
							sendMessage(msg);
							gui.appendMsg(msg);
						}
					}

				}
			} catch (IOException e) {
				removeClient(IDkey);
			}
		}
	}

}