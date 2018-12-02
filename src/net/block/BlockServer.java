package net.block;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockServer {
	@FunctionalInterface
	static interface ClientDisconnectable{
		void disconnect(Service service);
	}
	static List<Service> services = new ArrayList<BlockServer.Service>();
	static ReadWriteLock lock = new ReentrantReadWriteLock();
	static abstract class MessageDispather{
		List<Service> service ; 
		ReadWriteLock lock ; 
		ClientDisconnectable dis ;
		public MessageDispather(List<Service> service, ReadWriteLock lock, ClientDisconnectable dis) {
			this.service = service;
			this.lock = lock;
			this.dis = dis;
		}
		public void disconnect(Service service){
			System.out.println(service.address.toString() +" is disconnected!");
			dis.disconnect(service);
		}
		public void dispatch(Service except,String message){
			System.out.println("dispatch message from "+except.address + ",content : "+message);
			Lock l = lock.readLock() ; 
			try {
				l.lock();
				for (Service service : services) {
					if(service.equals(except)) continue ; 
					try {
						service.writer.write(message+"\r\n");
					} catch (Exception e) {
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				l.unlock(); 
			}
			
		}
	}
	static class Service implements Runnable{
		volatile boolean alive = true ;
		Socket socket ;
		BufferedReader reader ;
		BufferedWriter writer ; 
		SocketAddress address ;
		MessageDispather dispather ; 
		public Service(Socket socket, MessageDispather dispather) throws IOException {
			this.socket = socket;
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.address = socket.getRemoteSocketAddress() ; 
			this.dispather = dispather ; 
		}
		@Override
		public void run() {
			while(alive){
				try {
					dispather.dispatch(this, reader.readLine());
				} catch (IOException e) {
					dispather.disconnect(this);
				}
			}
		} 
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Service){
				if(((Service)obj).socket == this.socket) return true ; 
			}
			return false;
		}
	}
	public static void main(String[] args) throws IOException {
		ClientDisconnectable dis = (s)->{
			Lock l = lock.writeLock() ;
			try {
				l.lock();
				services.remove(s) ; 
				s.alive = false ; 
			} catch (Exception e) {
				e.printStackTrace();  
			}finally {
				l.unlock(); 
			}
		};
		MessageDispather dispather = new MessageDispather(services,lock,dis) {};
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8889); 
		System.out.println("Server startup");
		while(true){
			Socket socket = server.accept() ; 
			Service service = new Service(socket, dispather);
			Lock l = lock.writeLock() ;
			try {
				System.out.println("a client connected! " + service.address);
				l.lock();
				services.add(service) ; 
			} catch (Exception e) {
				e.printStackTrace();  
			}finally {
				l.unlock(); 
			}
			new Thread(service).start();
		}
	}
}














