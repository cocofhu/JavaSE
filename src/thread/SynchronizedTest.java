package thread;

public class SynchronizedTest implements Runnable{
	public static int data = 0; 
	public static void main(String[] args) {
		new Thread(new SynchronizedTest()).start();
		new Thread(new SynchronizedTest()).start();
	}
	public synchronized void m1() throws InterruptedException{
		data++ ;
		Thread.sleep(2000);
		System.out.println(data);
	}
	public synchronized void m2() throws InterruptedException{
		data = 2 ;
	}
	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
