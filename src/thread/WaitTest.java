package thread;

import java.net.ServerSocket;

public class WaitTest implements Runnable{
	public static Object o = new Object() ;
	@Override
	public void run() {
		synchronized(o){
			try {
				o.wait();
				System.out.println("NO");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void test(){
		System.out.println("Test");
		synchronized(o){
			System.out.println("121212");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		WaitTest w = new WaitTest() ;
		new Thread(w).start();
		Thread.sleep(1000);
		synchronized (o) {
			o.notify();
			System.out.println("BOOO");
			Thread.sleep(3000);
		}
		Thread.sleep(1000);
		w.test();
	}

}
