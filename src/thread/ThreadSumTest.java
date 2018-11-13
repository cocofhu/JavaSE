package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadSumTest implements Runnable{

	public long ret = 0 ; 
	private Iterator<Integer> start ;
	public ThreadSumTest(Iterator<Integer> start) {
		this.start = start;
	}
	@Override
	public void run() {
		while(start.hasNext()) ret+=start.next() ;
	}
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 200000000/4; i++) {
			a1.add(256);
			a2.add(256);
			a3.add(256);
			a4.add(256);
		}
		System.out.println("start...");
		long start = new Date().getTime();
		threads.add(new Thread(new ThreadSumTest(a1.iterator())));
		threads.add(new Thread(new ThreadSumTest(a2.iterator())));
		threads.add(new Thread(new ThreadSumTest(a3.iterator())));
		threads.add(new Thread(new ThreadSumTest(a4.iterator())));
		threads.forEach(e->e.start());
		threads.forEach(e->{try {
			e.join();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		System.out.println("wait...");
		long end = new Date().getTime();
		System.out.println(start);
		System.out.println(end);
		System.out.println(end - start);
		
	}
}
