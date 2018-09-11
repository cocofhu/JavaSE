package net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TwoSocket {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket1 = new Socket("127.0.0.1", 10000);
		socket1.getOutputStream().write("Hello".getBytes());
		socket1.getOutputStream().flush();
		Socket socket2 = new Socket("127.0.0.1", 10000);
		socket2.getOutputStream().flush();
		socket2.getOutputStream().write("Hello".getBytes());
		Thread.sleep(1000000);
	}
}
