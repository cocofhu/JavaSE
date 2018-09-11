package thread;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest2 {
	static int count = 0 ; 
	static class Product{
		private int id ; 
		public Product(int id){
			this.id = id ;
		}
		@Override
		public String toString() {
			return "Product :" + id ; 
		}
	}
	static class SyncStack{
		public ReentrantLock lock = new ReentrantLock(); 
		public Condition cnd = lock.newCondition();
		private Product[] ps = new Product[6] ; 
		private int index = 0 ;
		public void push(Product p){
			lock.lock();
			while(index == ps.length){
				try {
					cnd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			cnd.signalAll();
			ps[index] = p ; 
			index++ ;
			lock.unlock();
		}
		public Product pop(){
			lock.lock();
			while(index == 0){
				try {
					cnd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			cnd.signalAll();
			index -- ;
			Product p = ps[index] ; 
			lock.unlock();
			return p ;
		}
	}
	static class Producer implements Runnable{
		private SyncStack ss ;
		public Producer(SyncStack ss) {
			this.ss = ss ; 
		}
		@Override
		public void run() {
			while(true){
				Product p = new Product(count++) ;
				System.out.println("Produce :" +p);
				ss.push(p);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	static class Consumer implements Runnable{
		private SyncStack ss ;
		public Consumer(SyncStack ss) {
			this.ss = ss ; 
		}
		@Override
		public void run() {
			while(true){
				Product p = ss.pop();
				System.out.println("Consume :" +p);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		SyncStack ss = new SyncStack() ;
		new Thread(new Producer(ss)).start();
		new Thread(new Producer(ss)).start();
		new Thread(new Producer(ss)).start();
		new Thread(new Consumer(ss)).start();
	}
	
}
