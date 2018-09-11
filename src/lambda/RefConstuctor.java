package lambda;

public class RefConstuctor {
	static interface A{
		String test();
	}
	public static void main(String[] args) {
		A a = String::new ; 
	}
}
