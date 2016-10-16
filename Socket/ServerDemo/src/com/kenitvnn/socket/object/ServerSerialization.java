package com.kenitvnn.socket.object;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


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
	
				/**
				 * phân tải server ra thành nhiều thread
				 */
				new ServerThread(socket).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} 

	}
	
	
	public static void main(String[] args) {
		ServerSerialization server = new ServerSerialization();
		server.serve();
	}
	
	
}
