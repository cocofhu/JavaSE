package base;

public class IntegerTest {
	public static void main(String[] args){
		Integer a = new Integer(1);
		Integer b = new Integer(1) ;
		Integer c = 1 ; 
		Integer d = 1 ; 
		Integer e = 128 ; 
		Integer f = 128 ;
		int g = 128 ;
		int h = 128 ; 
		int i = 1 ;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(b==d);
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(e==g);
		System.out.println(g==h);
		System.out.println(i==a);
		System.out.println(f.equals(g));
	}
}
