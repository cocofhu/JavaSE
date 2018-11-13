package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class UDPClient {
	
	public static int recv(int port,byte buf[],int len) throws IOException{
		DatagramSocket datagramSocket = new DatagramSocket(port);
		datagramSocket.setSoTimeout(10000);
		DatagramPacket datagramPacket = new DatagramPacket(buf, len);
        datagramSocket.receive(datagramPacket);
        datagramSocket.close();
		return datagramPacket.getLength() ;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",8888);
		DataInputStream dis = new DataInputStream(socket.getInputStream()) ;
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream()) ;
		dos.writeUTF("1.txt");
		long count = dis.readLong();
		socket.close();
		for (long i = 0; i < count ; i++) {
			byte[] buf = new byte[1024];
			int len = recv(9999, buf, buf.length);
			System.out.println(new String(buf,0,len));
		}
		
		
		
	}
}
