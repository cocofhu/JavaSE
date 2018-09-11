package base;

public class FinalTest {
	public static void main(String[] args){
		final String a = "1" ;
		final String b = "2" ; 
		final String c = a + b ; 
		final String d = "12" ; 
		System.out.println(c==d); // true
	}
}
