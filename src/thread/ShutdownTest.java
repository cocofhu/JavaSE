package thread;

import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class ShutdownTest {
	public static void main(String[] args) throws InterruptedException {
		ShutdownTestClass s = new ShutdownTestClass() ; 
		new Thread(s).start();
		Thread.sleep(100);
		/**
		* 	这里会出现内存变量不一致的的现象
		* 	工作内存：即java线程的本地内存，是单独给某个线程分配的，存储局部变量等，同时也会复制主存的共享变量作为本地
		*	的副本，目的是为了减少和主存通信的频率，提高效率。
		*	主存：存储类成员变量等
		*	可见性是指的是线程访问变量是否是最新值。
		*	局部变量不存在可见性问题，而共享内存就会有可见性问题，
		*	因为本地线程在创建的时候，会从主存中读取一个共享变量的副本，且修改也是修改副本，
		*	且并不是立即刷新到主存中去，那么其他线程并不会马上共享变量的修改。 
		*	因此，线程B修改共享变量后，线程A并不会马上知晓，就会出现上述死循环的问题。
		*
		*	解决共享变量可见性问题，需要用volatile关键字修饰。
		*/
		s.shutdown();
		System.out.println("Stopped!");
	}
}
class ShutdownTestClass implements Runnable{
	private /*volatile*/ Boolean isRunning = true  ; 
	public synchronized void shutdown(){
		this.isRunning = false ; 
	}
	/*而当Thread在申请同一个锁M时，Thread的工作内存会被设置为无效，然后Thread会重新从主存中加载它要访问的变量到它的工作内存中 */
	/*
	 * 	synchronized
	 * 	1.获得互斥锁
	 *	2.清空工作内存
	 *	3.从主内存拷贝变量的最新副本到工作内存
	 *	4.执行代码
	 *	5.将更改后的共享变量的值刷新到主内存
	 *	6.释放互斥锁
	 *
	 * */
	public /*synchronized*/ boolean isRunning(){
		return this.isRunning ; 
	}
	@Override
	public synchronized void run() {
		while(isRunning()){
//			synchronized(ShutdownTest.class){}
//			Object o = new Object();
//			synchronized (o) {
//				
//			}
//			for (int i = 0; i < 100000; i++) {
//				
//			}
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		} 
	}
}
