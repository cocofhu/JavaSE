import java.util.concurrent.TimeUnit;


public class Test implements Runnable{
	private  boolean alive = true;
	@Override
	public void run() {
		while(alive) ;
	}
	public void shutdown(){
		alive = false ;
	}
	public static void main(String[] args) throws Exception {
		Test t = new Test() ;
		new Thread(t).start();
		TimeUnit.SECONDS.sleep(1);
		t.shutdown();
		System.out.println("Stopped");
	}
}
