import java.io.IOException;
import java.util.Random;

public class ExceptionTest {
	
	static int passion = Integer.MAX_VALUE/2 ; 
	static Random random = new Random() ; 
	// only 10 offset can cause program shutdown fast
	static int expectation = 10010 ;
	static int capability = 20000 ;
	public static boolean timeGoesBy(){
		passion += random.nextInt(capability) - expectation  ; 
		return passion > 0 ; 
	}
	public static void main(String[] args) {
		System.out.println("Program started...");
		long start = System.currentTimeMillis() ;
		try {
			while(timeGoesBy()) ;
				throw new IOException("Java is a very simple language not like C++");
		} catch (IOException e) {
			// if System.exit was called , the finally block will not execute
			// System.exit(0);		
			return ; // we have finally 
		} finally {
			System.out.println("although we have finally but who cares");
			System.out.println("during a month , we didn't find solution.");
			System.out.println("finally, we are over!");
			long end = System.currentTimeMillis() ;
			System.out.println("Program duration is :" + (end - start) + "ms");
		}
	}
}
