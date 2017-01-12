package marble.controller;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

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

	private Map<String, DataOutputStream> guest;
	private ArrayList<Thread> gamer;
	private String IDkey;
	private Member member;
	private String rutf;
	private String msgFromClient;
	private Receiver receiver;

	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public ServerBackground() {
		gamer = new ArrayList<Thread>();
		guest = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(guest);

	}

	public void connectionSignal() throws IOException {
		serverSocket = null;
		socket = null;
		
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

	public void addGuest(String nick, DataOutputStream out) throws IOException {
		System.out.println(nick + " 입장");
		guest.put(nick, out);
	}

	public void sendMessage(String msg) {
		System.out.println("sendMessage");
		for (int i = 0; i < gamer.size(); i++) {
			try {
				((Receiver) gamer.get(i)).out.writeUTF(msg);
				((Receiver) gamer.get(i)).out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	class Receiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;
		private ObjectInputStream ois; //게임정보 받을 스트림
		private ObjectOutputStream oos; //게임정보 전송할 스트림
		private Object pageGame; //게임정보가 담긴 객체받아줄 참조변수
		private Object marble;  //게임정보가 담긴 객체받아줄 참조변수
		public Receiver(Socket socket) {
			this.setSocket(socket);
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				
				System.out.println("Receiver 생성자");
			} catch (Exception e) {
			}
		}

		public void recordConfirm(String person) {

			System.out.println("recordConfirm, person : " + person);

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"));
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {

				info = (HashMap<String, Member>) ois.readObject();
				System.out.println("파일로부터 읽음");
				System.out.println(info);

				if (!info.containsKey(person)) {
					String[] contain = person.split(" ");
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

			} catch (EOFException e) { // 아무것도 없을 때

				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {
					System.out.println("minute.dat에 데이터가 없습니다");
					String[] contain = person.split(" ");
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
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))) {

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
			byte action = 0;
			try {
				IDkey = "unknown";
				addGuest(IDkey, out);
				int count = 0;
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				game: while (true) {// 버튼에 따른 처리 게임 시작 이전까지
					System.out.println("while");
					String log = "";
					choice = in.readByte();
					switch (choice) {
					case (byte)10:
						log = in.readUTF();
						recordConfirm(log);
						break;
					case (byte)20:
						log = in.readUTF();
						logConfirm(log);
						break;
					case (byte)30:
						gamer.add(receiver);
						if(pageGame!=null)
							oos.writeObject(pageGame);
						out.writeUTF(gamer.size() + " " + IDkey);
						try{
						pageGame= ois.readObject();}
						catch(ClassNotFoundException cnfe){
							System.out.println("객체 읽어들이기 실패");
						}
						
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
					System.out.println("게임대기 반복문 빠져나감");//확인용
					Receiver sequence[] = new Receiver[gamer.size()];
					for(int i =0; i<gamer.size();i++){
						sequence[i] = (Receiver)gamer.get(i);
					}
					System.out.println("게임시작시의 신호");
				while (true) {
					for (int k = 0; k < gamer.size(); k++) {
						try{
						pageGame = ois.readObject();//페이지 게임의 객체정보받기
						marble = ois.readObject();//마블컨트롤러의 객체정보받기
						}catch(ClassNotFoundException cnfe){}
							for(Receiver e : sequence){
								e.out.writeByte(100);
								e.oos.writeObject(pageGame);
								e.oos.writeObject(marble);
							
							}sequence[k].out.writeByte(110);
							int re =0;
							re=sequence[k].in.readInt();//for문 정지용
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
				// removeClient(IDkey);
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