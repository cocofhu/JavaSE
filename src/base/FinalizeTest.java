package base;

public class FinalizeTest {
	public static FinalizeTest ft = null ;
	public void test(){
		System.out.println("test");
	}
	public static void main(String[] args)throws Exception{
		new FinalizeTest();
		System.gc();
		Thread.sleep(2000);
		ft.test();
		
	}
	public void finalize(){
		ft = this ; 
	}
}
