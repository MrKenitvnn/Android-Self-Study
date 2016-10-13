package com.kenitvnn.socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	private ServerSocket server;

	public void serve () {
		try {
			server = new ServerSocket(1993);
			System.out.println("Server is ready...");
			Socket socket = server.accept();
			
			// get data from client
			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String requestString = bufferedReader.readLine();
			if (null != requestString) {
				System.out.println("Server received data: " + requestString);
				
				// process: select database, calculator....
				// response to client
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				printStream.println(requestString.toUpperCase());
			}
			
		} catch (IOException ex) {
			
		}
	}
	
	
	public static void main(String[] args) {
		SimpleServer server = new SimpleServer();
		server.serve();
	}
	
}
