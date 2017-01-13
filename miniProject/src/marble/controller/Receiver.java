package marble.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Receiver extends Thread {
 
 private Socket socket;
 private ObjectInputStream ois;
 private ObjectOutputStream oos;


 public Receiver(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
  System.out.println("Receiver 생성자 시작");
  //oos = new ObjectOutputStream(socket.getOutputStream());
  this.oos = oos;
  this.ois = ois;
  System.out.println("Receiver 생성자");
   
 }

 public ObjectInputStream getOis() {
  return ois;
 }

 public ObjectOutputStream getOos() {
  return oos;
 }
} 
