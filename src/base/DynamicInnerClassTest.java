package base;

public class DynamicInnerClassTest{
	private class InnerClass implements R{
		@Override
		public void test(){System.out.println("Test!");}
	}
	public R getR(){
		return new InnerClass();
	}
	public static void main(String[] args){
		new DynamicInnerClassTest().getR().test(); 
	}
}
interface R{
	void test();
}