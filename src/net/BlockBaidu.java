package net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockBaidu implements Runnable{
	public static AtomicInteger count = new AtomicInteger() ;
	public void run() {
		try {
			Socket s = new Socket("123.207.15.141", 20000);
			System.out.println("a thread connected num:"+count.getAndIncrement());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			new Thread(new BlockBaidu()).start();
			//Thread.sleep(10);
		}
		
	}
}
