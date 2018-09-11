package generic;

public class GenericConstructorTest {
	static class Foo<E>{
		public <T> Foo(T t){
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
		new Foo<Integer>("SSS");
		new <String>Foo<Integer>("asdsad");
	}                                                                                                                                                                        
}
