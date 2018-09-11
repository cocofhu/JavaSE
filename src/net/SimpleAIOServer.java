package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimpleAIOServer {
	static final int PORT = 30000 ; 
	public static void main(String[] args) {
		try(
				AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
			){
			serverChannel.bind(new InetSocketAddress(PORT)) ;
			while(true){
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				AsynchronousSocketChannel asc = future.get();
				System.out.println("1");
				asc.write(ByteBuffer.wrap("Hello Wrold!".getBytes("UTF-8"))) ;
			}
		} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
