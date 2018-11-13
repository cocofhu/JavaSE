import java.util.Random;

public class ExceptionTest {
	static int passion = Integer.MAX_VALUE/2 ; 
	static Random I = new Random() ; 
	// only 10 offset can cause program shutdown fast
	static int expectation = 10010 ;
	static int capability = 20000 ;
	public static boolean timeGoesBy(){
		passion += I.nextInt(capability) - expectation  ; 
		return passion > 0 ; 
	}
	public static boolean newLife(){
		// keep the passion always positive 
		passion = Integer.MAX_VALUE/2 ; 
		return  passion > 0 ; 
	}
	public static void main(String[] args) {
		System.out.println("Program started...");
		long start = System.currentTimeMillis() ;
		try {
			while(timeGoesBy()) ;
				throw new IllegalStateException("something was wrong...");
		} catch (IllegalStateException e) {
			// if System.exit was called , the finally block will not execute
			// System.exit(0);		
			return ; // we have finally 
		} finally {
			System.out.println("although we have finally but who cares");
			System.out.println("during a month , we didn't find solution.");
			System.out.println("finally, we are over!");
			synchronized (I) {
				try {
					// I will not be a deadlock , I wait for some time not too long
					I.wait(20000);
					
				} catch (InterruptedException e) {
					// be interrupted and end it 
				}
			}
			// injection some code by AOP (aspect-oriented programming) can make the program executing right
			long end = System.currentTimeMillis() ;
			System.out.println("Program duration is :" + (end - start) + "ms");
		}
	}
}
