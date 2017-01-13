package marble.controller;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import marble.controller.Receiver;
import marble.model.Member;
import marble.run.ServerGui;
import marble.view.*;

//입장부터 네트워크화
public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private ServerGui gui;
	private byte choice;
	private String msg;
	private Map<String, Member> info;
	private Member[] players;

	private Map<String, ObjectOutputStream> guest;
	private Map<String, Socket> socketMap;
	private ArrayList<Receiver> gamer;
	private String IDkey;
	private Member member;
	private String rutf;
	private String msgFromClient;
	private boolean flag = true;
	private ReceiverManager receiverManager;
	
	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public ServerBackground() {
		gamer = new ArrayList<Receiver>();
		guest = new HashMap<String, ObjectOutputStream>();
		socketMap = new HashMap<String, Socket>();
		Collections.synchronizedMap(guest);

	}

	public void connectionSignal() throws IOException {
		serverSocket = null;
		socket = null;
		try {
			serverSocket = new ServerSocket(5000);
			while (true) {
				socket = serverSocket.accept();
				System.out.println("서버 대기중...");
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				
				socketMap.put(IDkey, socket);
				
				if (flag==true) {
				receiverManager = new ReceiverManager();
				receiverManager.start();
				flag = false;
				
				}
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

	public void addGuest(String nick, ObjectOutputStream out) throws IOException {
		System.out.println(nick + " 입장");
		guest.put(nick, out);
	}

	public void sendMessage(String msg) {
		System.out.println("sendMessage");
		for (int i = 0; i < gamer.size(); i++) {
			try {
				gamer.get(i).getOos().writeUTF(msg);
				gamer.get(i).getOos().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	class ReceiverManager extends Thread {

		public ReceiverManager() {
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				System.out.println("ReceiverManager 생성자");
			} catch (Exception e) {
			}
		}

		public void recordConfirm(String person) {

			System.out.println("recordConfirm, person : " + person);

			try (ObjectInputStream ois_minute = 
					new ObjectInputStream(
							new FileInputStream("minute.dat"));
				ObjectOutputStream oos_minute = 
						new ObjectOutputStream(
								new FileOutputStream(
										"minute.dat"))) {

				info = (HashMap<String, Member>) ois_minute.readObject();
				System.out.println("파일로부터 읽음");
				System.out.println(info);

				if (!info.containsKey(person)) {
					String[] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info.put(contain[0], member);
					oos_minute.writeObject(info);
					oos.writeByte(21);
					System.out.println("중복된 아이디 X (21)");
				} else {
					System.out.println("중복된 아이디 (11)");
					oos.writeByte(11);
				}

			} catch (EOFException e) { // 아무것도 없을 때

				try (ObjectOutputStream oos_minute = 
						new ObjectOutputStream(
								new FileOutputStream(
										"minute.dat"))) {
					System.out.println("minute.dat에 데이터가 없습니다");
					String[] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info = new HashMap<String, Member>();
					info.put(contain[0], member);
					oos_minute.writeObject(info);
					oos.writeByte(21);
					oos.flush();
					System.out.println("중복된 아이디 X ()21");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			} catch (FileNotFoundException e) {

				try (FileOutputStream fos = new FileOutputStream("minute.dat")) {
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
			try (ObjectInputStream ois_minute = 
					new ObjectInputStream(
							new FileInputStream(
									"minute.dat"))) {

				info = (HashMap) ois_minute.readObject();
				String[] teared = name.split(" ");

				if (info.containsKey(teared[0])) {
					if (((Member) info.get(teared[0])).getPassword().equals(teared[1])) {
						oos.writeByte(31);
						oos.flush();
						IDkey = teared[0];
						System.out.println("로그인 값 비교 완료");
					}
				} else {
					oos.writeByte(11);
					oos.flush();
					System.out.println("해당 회원정보 존재하지 X");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void run() {
			
			byte action = 0;
			int index;
			
			try {
				IDkey = "unknown";
				addGuest(IDkey, oos);
				int count = 0;
				//BufferedReader br = new BufferedReader(new InputStreamReader(in));
				PageGame gameInfo= null;
				game: while (true) { // 버튼에 따른 처리 게임 시작 이전까지
					System.out.println("while");
					String log = "";
					choice = ois.readByte();
					switch (choice) {
					case (byte)10:
						log = ois.readUTF();
						recordConfirm(log);
						break;
					case (byte)20:
						log = ois.readUTF();
						logConfirm(log);
						break;
					case (byte)30:
						gamer.add(new Receiver(socket, oos, ois));
						index = gamer.size()-1;
						ObjectOutputStream oos2 = gamer.get(index).getOos();
						ObjectInputStream ois2 = gamer.get(index).getOis();
						oos2.writeUTF(index+1 + " " + IDkey);
						oos2.flush();
						System.out.println("fl");
						gameInfo = (PageGame)(gamer.get(index).getOis().readObject());
						System.out.println("받");
						for(int i =0; i<gamer.size(); i++){
							gamer.get(i).getOos().writeObject(gameInfo);
							gamer.get(i).getOos().flush();
						}
						System.out.println("끝");
						break;
					case (byte)40:
						count++;
						if (count < gamer.size())
							break;
						else
							sendMessage("게임을 시작합니다.");
						break game;
					}
				}
				System.out.println("action");//확인용
				Object pageGame = new Object();
				Object marble = new Object(); 
				while (true) {
				byte bridge = 0;
					//out.writeByte(100);
					
					for (int k = 0; k < gamer.size(); k++) {
						
						System.out.println("주사위 활성화 ");
						gamer.get(k).getOos().writeByte(110);
						gamer.get(k).getOos().flush();
						pageGame =(PageGame)(gamer.get(k).getOis().readObject());
						gamer.get(k).getOos().writeByte(1); //객체 받았다는 신호
						gamer.get(k).getOos().flush();
						marble = (MarbleController)(gamer.get(k).getOis().readObject());
						gamer.get(k).getOos().writeInt(2); //객체 전부 받았다는신호
						gamer.get(k).getOos().flush();
								
						
						for (int j=0 ; j< gamer.size(); j++)  {
							System.out.println("주사위 비활성화 ");
							gamer.get(j).getOos().writeByte(100);
							gamer.get(j).getOos().flush();
							gamer.get(j).getOos().writeObject(pageGame);
							gamer.get(j).getOos().flush();
							bridge = gamer.get(j).getOis().readByte(); //게임판 갱신했다는 신호
							gamer.get(j).getOos().writeObject(marble); 
							gamer.get(j).getOos().flush();
							bridge = gamer.get(j).getOis().readByte(); //게임판 갱신했다는 신호
							}

									
					}
				}

				/*
				 * while (true) { if ((msgFromClient = br.readLine())!= null) {
				 * msg = IDkey + " : " + msgFromClient; System.out.println(msg);
				 * sendMessage(msg+"\n"); gui.appendMsg(msg+"\n"); } }
				 */

			} catch (BindException e) {
				System.out.println("BindException 발생!");
				// removeClient(IDkey);
			} catch (IOException e) {
				e.printStackTrace();
				// removeClient(IDkey);
			} catch(ClassNotFoundException e3){
				System.out.println("클래스를 찾을수가 없습니다.");
			}
		}


		public Socket getSocket() {
			return socket;
		}

	}
	
}