package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest{
	public static void main(String[] args) {
		//Executors.newCachedThreadPool();//Executors.newFixedThreadPool(1);//Executors.newSingleThreadExecutor() ; 
		ExecutorService es = Executors.newScheduledThreadPool(2);
		Runnable r1 = ()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				if(i==9){
					int t = 1/0 ;
				}
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		es.execute(r1);
	}

}
