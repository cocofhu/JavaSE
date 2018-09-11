package thread;

public class ThreadLocalTest implements Runnable{
	public ThreadLocal<Integer> i = new ThreadLocal<Integer>() ;
	@Override
	public void run() {
		System.out.println(i.get());
	}
	public static void main(String[] args) {
		ThreadLocalTest t = new ThreadLocalTest() ;
		t.i.set(6);
		System.out.println(t.i.get());
		new Thread(t).start();
	}
}
