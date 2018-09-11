package thread;

public class DaemonThreadTest implements Runnable{
	public static void main(String[] args) {
		Thread t =new Thread(new DaemonThreadTest());
		//t.setDaemon(true);
		t.start();
	}

	@Override
	public void run() {
		while(true)System.out.println("Deamon");
	}
}
