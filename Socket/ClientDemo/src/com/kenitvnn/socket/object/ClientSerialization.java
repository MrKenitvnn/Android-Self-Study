package com.kenitvnn.socket.object;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.ken.itvnn.models.Message;


public class ClientSerialization {
	
	
	public void connect () {
		try {
			Socket socket = new Socket("localhost", 1993);
			System.out.println("Client is ready..");
			
			// sending
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			Message m1 = new Message("Learn client 3", "socket");
			objectOutputStream.writeObject(m1);
			
			// receive data
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			Message m2 = (Message) objectInputStream.readObject();
			if (m2 != null) {
				System.out.println("Receivd from server: "
						+ m2.getTitle() + " " + m2.getBody());	
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientSerialization client = new ClientSerialization();
		client.connect();
	}
	
	
}
