package thread;

public class PriorityTest implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new PriorityTest());
		Thread t2 = new Thread(new PriorityTest());
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		while(true)
		System.out.println(Thread.currentThread().getName()+"11111111111");
	}

}
