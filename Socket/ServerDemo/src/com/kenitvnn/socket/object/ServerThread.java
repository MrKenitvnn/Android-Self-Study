package com.kenitvnn.socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ken.itvnn.models.Message;

public class ServerThread extends Thread {
	
	private Socket socket;
	
	
	public ServerThread (Socket socket) {
		this.socket = socket;
	}
	
	
	public void run () {
		
		// receive
		ObjectInputStream objectInputStream;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		
			Message m1 = (Message) objectInputStream.readObject();
			System.out.println("Receive a message from client: "
					+ m1.getTitle() + " " + m1.getBody());
			
			// do something
			if (m1 != null) {
				// send data to client
				Message m2 = new Message("Ebook", "Java programming language");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				objectOutputStream.writeObject(m2);
				System.out.println("Sent a message to client.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
