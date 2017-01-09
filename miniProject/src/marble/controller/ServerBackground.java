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

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;
	private Map<String, Member> info;
	private Member[] players;
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() throws IOException {
		
		Collections.synchronizedMap(clientsMap);
		serverSocket = new ServerSocket(5000);
		socket = serverSocket.accept();
		
		while (true) {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println("서버 대기중...");
			switch(dis.readUTF()){
			case "회원가입 실행" :	Record record = new Record(socket);
			Thread t1 = new Thread(record);
			
				record.start(); if(dis.readInt()==1)record.stop();  break;
			case "로그인 실행" :	LogConfirm confirm = new LogConfirm(socket);
				confirm.start(); if(dis.readInt()==0)confirm.stop(); 
			while(true){
			System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
			Receiver receiver = new Receiver(socket);
			receiver.start();
			}
		}
		}
	}

	public static void main(String[] args) throws IOException {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

	public void addClient(String nick, DataOutputStream out) throws IOException {
		sendMessage(nick + "님이 접속하셨습니다.\n");
		clientsMap.put(nick, out);
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

	class Record extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String key;

	
		public Record(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			key = in.readUTF();
		}

		public void run() {
			String[] keys = key.split(" ");
			Member m = new Member(keys[0], keys[1]);

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))) {
				info = (HashMap) ois.readObject();
				if (!info.get(keys[0]).equals(m)) {
					info.put(keys[0], m);
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {
						oos.writeObject(info);
						oos.flush();
						out.writeInt(1);
						System.out.println("저장성공");
					} catch (Exception e3) {
					}
				} 
				else
					out.writeInt(0);
				System.out.println("저장실패");
			} catch (Exception e) {
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("minute.dat"))) {
					info = new HashMap<String, Member>();
					info.put(keys[0], m);
					oos.flush();
					out.writeInt(1);
				} catch (Exception e2) {
				}
			}
		}
	}

	class LogConfirm extends Thread{
		private DataInputStream in;
		private DataOutputStream out;
		private String keys;
		
		public LogConfirm(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			 keys= in.readUTF();
			
	}
		public void run(){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("minute.dat"))){
			info = (HashMap)ois.readObject();
			
			 String[] teared = keys.split(" ");
			 if(info.containsKey(teared[0])){
				if(((Member)info.get(teared[0])).getId().equals(teared[1]))
				 out.writeInt(0);
			 }
			 else
				 out.writeInt(1);
			
		}catch(Exception e){
			
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}			
	}
		
	
	
	
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String nick;

		public Receiver(Socket socket) throws IOException{
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			nick = in.readUTF();
			addClient(nick, out);
		}

		public void run() {
			try {
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				removeClient(nick);
			}
		}
	}
}