package base;

public class InnerClassConstructorTest {
	class UnStaticClass{}
	static class StaticClass{}
	public static void main(String[] args){
		InnerClassConstructorTest icc = new InnerClassConstructorTest() ; 
		icc.new UnStaticClass();
		new InnerClassConstructorTest.StaticClass();
		
	}
}
