package thread;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
	
	public static void main(String[] args) {
		final SynchronousQueue<String> sq = new SynchronousQueue<String>();
		new Thread(()->{
			try {
				while(true) sq.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			while(true)
				try {
					sq.put("asdsad");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
		new Thread(()->{
			while(true)
				try {
					sq.put("asdsad");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
	}
}
