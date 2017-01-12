package marble.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public Receiver(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
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
}
