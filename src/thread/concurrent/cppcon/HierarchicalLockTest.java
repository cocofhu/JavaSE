package thread.concurrent.cppcon;

import java.util.Stack;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HierarchicalLockTest {
	/**
	 * 使用层次锁来避免死锁
	 * @author Pouee
	 * 为了避免死锁,当同时使用两个或多个锁时,只需保证加锁的顺序是相同的,就可以很大程度上的避免死锁.
	 * 层次锁规定:当锁定层次较低的锁时,就不能锁定更高层次的锁(如果这样做将抛出异常).
	 */
	static class HierarchicalLock implements Lock{
		// 因为是可重入锁,用一个栈来保存每次加锁的层次号
		private Stack<Long> hierarchicalBackUp = new Stack<>() ;
		private Lock lock = new ReentrantLock();
		private final long hierarchical ;
		private static ThreadLocal<Long> threadHierarchical = new ThreadLocal<Long>() ;
		public HierarchicalLock(long hierarchical) {
			this.hierarchical = hierarchical;
		}
		// 这里没有加锁 避免写操作
		private void check(){
			// check hierarchical for avoiding deadlock
			if(threadHierarchical.get() == null){
				return ; 
			}
			if( threadHierarchical.get() < hierarchical){
				throw new RejectedExecutionException("");
			}
		}
		
		@Override
		public void lock() {	// synchronized 加在这里将造成死锁
			check();
			// 保证数据的一致性(如果创建层次号相同的对象,这里将可能死锁)
			synchronized (this) {
				Long backup = threadHierarchical.get() ;
				if(backup == null) backup = Long.MAX_VALUE;
				hierarchicalBackUp.push(backup);
				threadHierarchical.set(hierarchical);
				lock.lock();
			}
		}
		
		@Override
		public void unlock() { // 不会存在数据不一致
			threadHierarchical.set(hierarchicalBackUp.pop());
			lock.unlock();
		}
		@Override
		public boolean tryLock() {
			throw new UnsupportedOperationException("unsupported");
		}
		@Override
		public void lockInterruptibly() throws InterruptedException {
			throw new UnsupportedOperationException("unsupported");
		}
		@Override
		public Condition newCondition() {
			throw new UnsupportedOperationException("unsupported");
		}
		@Override
		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			throw new UnsupportedOperationException("unsupported");
		}
	}
	static class A{
		public final long hierarchical ; 
		public final Lock lock ;
		public A(long h){
			this.hierarchical = h ; 
			lock = new HierarchicalLock(hierarchical);
		}
		public void swap(A a){
			try {
				this.lock.lock();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					// 没有RAII机制 只能主动释放锁
					a.lock.lock();
				} catch (Exception e) {
					this.lock.unlock();
					throw e ;
				}
				
				System.out.println("do something...");
				
				
				this.lock.unlock();
				a.lock.unlock();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		A a = new A(1000);
		A b = new A(200);
		int i = 10 ;
		new Thread(()->{
			a.swap(b);
		}).start();
		Thread.sleep(200);
		new Thread(()->{
			b.swap(a);
		}).start();
		while(i > 0){
			Thread.sleep(100);
			new Thread(()->{
				a.swap(b);
			}).start();
			i--;
		}
		
	}
}
