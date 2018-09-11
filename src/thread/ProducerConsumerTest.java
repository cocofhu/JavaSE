package thread;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ProducerConsumerTest {
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
		private Product[] ps = new Product[6] ; 
		private int index = 0 ;
		public synchronized void push(Product p){
			while(index == ps.length){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.notifyAll(); 
			ps[index] = p ; 
			index++ ;
		}
		public synchronized Product pop(){
			while(index == 0){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.notifyAll(); 
			index -- ;
			return ps[index] ;
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
		System.setOut(new PrintStream(new FileOutputStream("D:\\test.txt")));
		SyncStack ss = new SyncStack() ;
		new Thread(new Producer(ss)).start();
		new Thread(new Producer(ss)).start();
		new Thread(new Producer(ss)).start();
		new Thread(new Consumer(ss)).start();
	}
	
}
