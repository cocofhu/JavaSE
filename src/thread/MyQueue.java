package thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue<T> {
	private final Object lock = new Object() ;
	private LinkedList<T> list = new LinkedList<T>();
	private AtomicInteger count = new AtomicInteger(0);
	private final int maxSize ; 
	public MyQueue(int maxSize){
		this.maxSize = maxSize ;
	}
	public void put(T t){
		synchronized(lock){
			while(this.maxSize == count.get()){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(t) ; 
			count.incrementAndGet() ; 
			lock.notifyAll(); 
		}
	}
	public T take(){
		synchronized(lock){
			T ret  = null ;
			while(0 == count.get()){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			ret = list.removeFirst() ; 
			count.decrementAndGet() ; 
			lock.notifyAll();
			return ret ; 
		}
	}
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>(5) ; 
		q.put(1);
		q.put(2);
		q.put(3);
		q.put(4);
		q.put(5);
		q.put(5);
	}
}
