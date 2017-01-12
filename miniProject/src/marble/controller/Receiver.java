package marble.controller;

import java.io.*;
import java.net.Socket;

public class Receiver extends Thread {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	public Receiver(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			setOis(new ObjectInputStream (socket.getInputStream()));
			setOos(new ObjectOutputStream (socket.getOutputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
