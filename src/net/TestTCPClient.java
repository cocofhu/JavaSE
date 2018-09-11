package net;

import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TestTCPClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("127.0.0.1",8888);
		OutputStream out = socket.getOutputStream();
		int count = 0; 
		while(true){
			count++;
			out.write("Hello World".getBytes());
			System.out.println("WR FIN TOTAL : "+ count);
		}
	}
}
