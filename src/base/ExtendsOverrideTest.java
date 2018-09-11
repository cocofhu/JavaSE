package base;

public class ExtendsOverrideTest{
	
	public static void main(String[] args){
		Sub s = new Sub(); // SSSSS!!!
		System.out.println("----------------------");
	}
	
}
class Base{
	public Base(){((Base)this).test();}//
	public void test(){System.out.println("test!!!");};
}
class Sub extends Base{
	String name = "" ; 
	public void test(){
		System.out.println("SSSSS!!!"+name.length());
	}
}