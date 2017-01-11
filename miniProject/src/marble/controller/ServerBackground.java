package marble.controller;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import marble.model.Member;
import marble.run.ServerGui;
import marble.view.*;

//입장부터 네트워크화
public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private byte choice;
	private String msg;
	private Map<String, Member> info;
	private Member[] players;
	private Map<String, DataOutputStream> clientsMap;
	private Map<String, DataOutputStream> guest;
	private Map<String, Receiver> gamer;
	private String IDkey;
	private Member member;
	private String rutf;
	private Receiver receiver;
	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public ServerBackground() {
		clientsMap = new HashMap<String, DataOutputStream>();
		guest = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(guest);
		Collections.synchronizedMap(clientsMap);

	}

	public void connectionSignal() throws IOException {
		serverSocket = null;
		socket = null;
		gamer = new HashMap<String, Receiver>();
		try {
			serverSocket = new ServerSocket(5000);
			while (true) {
				socket = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				System.out.println("서버 대기중...");
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				receiver = new Receiver(socket);
				receiver.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		try {
			ServerBackground serverBackground = new ServerBackground();
			serverBackground.connectionSignal();
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void addClient(String nick, DataOutputStream out) throws IOException {
		sendMessage(nick + "님이 접속하셨습니다.\n");
		clientsMap.put(nick, out);
	}

	public void addGuest(String nick, DataOutputStream out) throws IOException {
		System.out.println(nick + " 입장");
		guest.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "님이 나가셨습니다.\n");
		clientsMap.remove(nick);
	}

	public void sendMessage(String msg) {
		System.out.println("sendMessage");
		Iterator<String> it = clientsMap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
				clientsMap.get(key).flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void controlGamer(){
		Set order = gamer.keySet();
		Iterator iter = order.iterator();
		while(iter.hasNext()){
			
		}
		
		
	}
	class Receiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		public Receiver(Socket socket) {
			this.setSocket(socket);
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				System.out.println("Receiver 생성자");
			} catch (Exception e) {
			}
		}

		public void recordConfirm(String person){
			
			System.out.println("recordConfirm, person : " + person);
			
			try (ObjectInputStream ois =
					new ObjectInputStream(
							new FileInputStream(
									"minute.dat"));
				ObjectOutputStream oos = 
						new ObjectOutputStream(
								new FileOutputStream(
										"minute.dat"))) {
				
				info = (HashMap<String,Member>) ois.readObject();
				System.out.println("파일로부터 읽음");
				System.out.println(info);
				
				if(!info.containsKey(person)) {
					String [] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info.put(contain[0], member);
					oos.writeObject(info);
					oos.flush();
					out.writeByte(21);
					System.out.println("중복된 아이디 X ()21");
				} else {
					System.out.println("중복된 아이디 (11)");
					out.writeByte(11);
				}
				
			} catch(EOFException e) { // 아무것도 없을 때
				
				try (ObjectOutputStream oos = 
						new ObjectOutputStream(
								new FileOutputStream(
										"minute.dat"))) {
					System.out.println("minute.dat에 데이터가 없습니다");
					String [] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info = new HashMap<String, Member>();
					info.put(contain[0], member);
					oos.writeObject(info);
					oos.flush();
					out.writeByte(21);
					System.out.println("중복된 아이디 X ()21");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			} catch (FileNotFoundException e) {
				
				try (FileOutputStream fos = 
							new FileOutputStream(
									"minute.dat")) {
				} catch (IOException e2) {
					System.out.println("IOException");
					// TODO Auto-generated catch block
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} 
		
		
		public void logConfirm(String name) {
			System.out.println("logConfirm, 아이디 비번 : " + name);
			try (ObjectInputStream ois =
					new ObjectInputStream(
							new FileInputStream(
									"minute.dat"))) {
				
				info = (HashMap) ois.readObject();
				String[] teared = name.split(" ");
				
				if (info.containsKey(teared[0])) {
					if (((Member) info.get(teared[0])).getPassword().equals(teared[1])) {
						out.writeByte(31);
						IDkey = teared[0];
						System.out.println("로그인 값 비교 완료");
					}
				} else {
					out.writeByte(11);
					System.out.println("해당 회원정보 존재하지 X");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void run() {

			try {
				IDkey = "unknown";
				addGuest(IDkey, out);
				
				while (true) {
					System.out.println("while");
					String log = "";
					choice = in.readByte(); 
					switch (choice) {
					case 0010:
						log = in.readUTF();
						recordConfirm(log);
						break;
					case 0020:
						log = in.readUTF();
						logConfirm(log);
						break;
					case 0030:
						addClient(IDkey, out);
						gamer.put(IDkey, receiver);
						
						while (true) {
							if ((rutf = in.readUTF()) == null)
								break;
							msg = IDkey + " : " + rutf;
							System.out.println(msg);
							sendMessage(msg);
							gui.appendMsg(msg);
						}
					}
				}
			} catch (BindException e) {
				System.out.println("BindException 발생!");
				//removeClient(IDkey);
			} catch (IOException e) {
				//removeClient(IDkey);
			}
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}
	}
}