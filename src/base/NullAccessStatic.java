package base;

public class NullAccessStatic {
	private static void test(){
		System.out.println("testing...");
	}
	public static void main(String[] args){
		NullAccessStatic nas =null ;
		nas.test();
	}
}
