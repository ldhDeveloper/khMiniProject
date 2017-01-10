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
	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public ServerBackground() {
		clientsMap = new HashMap<String, DataOutputStream>();
		guest = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(guest);
		Collections.synchronizedMap(clientsMap);

	}

	public void start() throws IOException {

		serverSocket = null;

		socket = null;
		try {
			serverSocket = new ServerSocket(5000);
			socket = serverSocket.accept();

			while (true) {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				System.out.println("서버 대기중...");
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws IOException {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.start();
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

		public Receiver(Socket socket) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());

			} catch (Exception e) {
			}
		}

		public void recordConfirm(String person){
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))) {
				info = (HashMap) ois.readObject();
								
				if(!info.containsKey(person)){
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))){
				String [] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info.put(contain[0], member);
					oos.writeObject(info);
					oos.flush();
					out.writeByte(0021);
				}catch(Exception e2){}
				}else
					out.writeByte(0011);
									
			}catch(Exception e){
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))){
					String [] contain = person.split(" ");
					member = new Member(contain[0], contain[1]);
					info.put(contain[0], member);
					oos.writeObject(info);
					oos.flush();
					out.writeByte(0021);
				}catch(Exception e3){}
			}
		}
		
		
		public void logConfirm(String name) {
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

		public void run() {

			try {
				int order = 1;
				IDkey = "unknown";
				System.out.println(IDkey);
				addGuest(IDkey, out);
				while (true) {
					String log = "";
					choice = in.readByte(); 
					switch (choice) {
					case 0010:
						log = in.readUTF(); recordConfirm(log);
						break;
					case 0020:
						log = in.readUTF(); String[] confirm = log.split(" ");  
						logConfirm(confirm[0]);
						break;
					case 0030:
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