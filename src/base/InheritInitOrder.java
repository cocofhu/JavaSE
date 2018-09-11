package base;

public class InheritInitOrder {
	private String name = "base" ;
	public InheritInitOrder() {
		callName();
	}
	public void callName(){
		System.out.println("BASE CALLED");
		System.out.println(name);
	}
	static class Sub extends InheritInitOrder {
		private String name = "sub" ; 
		public void callName(){
			System.out.println("SUB CALLED");
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		new Sub();
	}
}
