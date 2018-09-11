package base;

public class BlockInitialTest {
	public BlockInitialTest(){
		System.out.println("constructor running...");
	}
	{
		System.out.println("initializing...");
	}
	static{
		System.out.println("static initializing...");
	}
	public static void main(String[] args){
		System.out.println("program started...");
		new BlockInitialTest();
		new BlockInitialTest();
		System.out.println("program terminated...");
	}
}
