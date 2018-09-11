package net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888,1);
		Socket socket = ss.accept();
		InputStream in  = socket.getInputStream();
		byte[] buffer = new byte[2048] ;
		ss.close();
		while(true){
			int count = in.read(buffer);
			//System.out.println(new String(buffer,0,count));
		}
	}
}
