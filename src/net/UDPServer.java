package net;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class UDPServer implements Runnable{
	private int port ;
	private String ip ;
	private String path ;
	private static final int BUF_SIZE = 1024 ;
	private static final int SERVER_TCP_PORT = 8888 ;
	private static final int SERVER_UDP_PORT = 9999 ;
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(SERVER_TCP_PORT);
		System.out.println("server started successfully! tcp port:"+SERVER_TCP_PORT + ",udp port:"+SERVER_UDP_PORT);
		while(true){
			Socket socket = server.accept();
			DataInputStream dis = null ;
			DataOutputStream dos = null ;
			String ip = socket.getInetAddress().toString().substring(1);
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				String path = dis.readUTF();
				long len = new File(path).length();
				long count = (len+BUF_SIZE-1)/BUF_SIZE ;
				dos.writeLong(count);
				System.out.println("A client connected! remote ip address : " 
						+ ip + ", request file path :" + path + " data size : " + len + ",packet count:"+count);
				new Thread(new UDPServer(SERVER_UDP_PORT, ip, path)).start();
				
			}catch(FileNotFoundException e){
				
			}catch (Exception e) {
				
			}finally {
				if(dis!=null)dis.close();
				if(dos!=null)dos.close();
				socket.close();
			}
		}
	}
	
	public UDPServer(int port, String ip, String path) {
		this.port = port;
		this.ip = ip;
		this.path = path;
	}
	@Override
	public void run() {
		FileInputStream fis = null ;
		try {
			Thread.sleep(1000);
			fis = new FileInputStream(path);
			byte[] buf = new byte[BUF_SIZE];
			int len = -1 ;
			while((len = fis.read(buf, 0, BUF_SIZE)) != 0){
				send(ip, port, buf, len);
			}
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static int send(String ip,int port,byte buf[],int len) throws IOException{
		DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket datagramPacket = new DatagramPacket(buf, len, address, port);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
        return datagramPacket.getLength();
	}
}
