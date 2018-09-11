package base;

public class NaNTest {
	public static void main(String[] args){
		double a = 0.0/0.0 ;
		double b = 0.0/0.0 ; 
		System.out.println(a==b); // false
		System.out.println(0.0/0.0);
		
	}
}
