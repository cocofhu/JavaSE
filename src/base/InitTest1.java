package base;

public class InitTest1 {
	static{
		System.out.println("static");
	}
	
	Integer k = 200 ;
	{
		System.out.println("Block");
		k = 100 ;
		new Thread().start();
	}
	{
		int k =300 ;
		k = 200 ;
	}
	public InitTest1() {
		System.out.println(k);
	}
	public static void main(String[] args) {
		new InitTest1();
	}
}
