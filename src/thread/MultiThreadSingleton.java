package thread;

public class MultiThreadSingleton {
	private static MultiThreadSingleton instance = null ;
	private MultiThreadSingleton(){}
	{
		// create at class loading
		// instance = new MultiThreadSingleton() ;
	}
	public static MultiThreadSingleton getInstance(){
		if(instance == null){
			synchronized (MultiThreadSingleton.class) {
				if(instance == null) instance = new MultiThreadSingleton();
			}
		}
		return instance ;
	}
	
}
