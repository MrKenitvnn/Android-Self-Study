package com.kenitvnn.socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.ken.itvnn.models.Message;


public class ServerSerialization {
	
	private ServerSocket server;

	public void serve () {
		try {
			server = new ServerSocket(1993);
			System.out.println("Server is ready...");
			
			int count = 0;
			while (true) {
				System.out.println("Server count Client: " + ++count);
				Socket socket = server.accept();
	
				// receive
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
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

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ServerSerialization server = new ServerSerialization();
		server.serve();
	}
	
	
}
