package thread;

public class ThreadGroupTest {
	public static void main(String[] args) {
		ThreadGroup mtg = Thread.currentThread().getThreadGroup() ;
		System.out.println("the name of main thread is "+ mtg.getName());
		System.out.println("is deamonThread "+ mtg.isDaemon());
		ThreadGroup tg = new ThreadGroup("TG") ; 
		tg.setDaemon(true);
		new Thread(tg,()->{while(true);}).start();
	}
}
