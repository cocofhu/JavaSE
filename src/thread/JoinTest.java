package thread;

public class JoinTest implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new JoinTest()) ; 
		thread.start();
		thread.join();
		for (int i = 0; i < 50 ; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 50 ; i++) {
			System.out.println(i);
		}
	}

}
