package net;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10000);
		Socket s1 = ss.accept();
		byte []buf =new byte[1024];
		int len = s1.getInputStream().read(buf);
		System.out.println(new String(buf,0,len));
		
		Socket s2 = ss.accept();
		len = s2.getInputStream().read(buf);
		System.out.println(new String(buf,0,len));
		
		
		Thread.sleep(100000);
	}
}
