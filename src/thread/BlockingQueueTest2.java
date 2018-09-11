package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest2 {
	static BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2) ;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while (true) {
				System.out.println(1);
				try {
					bq.put("1");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}}).start();
		new Thread(() -> {
			while (true) {
				System.out.println(1);
				try {
					bq.put("1");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}}).start();
		new Thread(() -> {
			while (true) {
				try {
					System.out.println("C"+bq.take());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}}).start();
		
	}
}
