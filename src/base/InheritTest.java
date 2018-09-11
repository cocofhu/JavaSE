package base;



public class InheritTest {
	static class A{
		public A(){
			f();
		}
		public void f(){
			System.out.println("AAAA");
		}
	}
	static class B extends A{
		public void f(){
			System.out.println("BBBB");
		}
	}
	static class C extends B{
		public void f(){
	
			System.out.println("CCCC");
		}
	}
	public static void main(String[] args) {
		new C();
	}
}
