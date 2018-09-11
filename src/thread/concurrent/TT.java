package thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TT implements Runnable{
	private int count = 0 ; 
	private ReentrantLock lock = new ReentrantLock() ;
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) throws InterruptedException {
		TT t = new TT();
		for (int i = 0; i < 10; i++) {
			new Thread(t).start();
		}
		Thread.sleep(1000);
		//System.out.println(t.count);
	}
}
