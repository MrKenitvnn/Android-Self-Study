package com.kenitvnn.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class SimpleClient {

	public void connect () {
		try {
			Socket socket = new Socket("localhost", 1993);
			
			// sending to server
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			printStream.println("Data from client.");
			
			// receive data from server
			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = bufferedReader.readLine();
			
			if (null != response) {
				System.out.println("Server answered: " + response);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.connect();
	}
	
	
}
