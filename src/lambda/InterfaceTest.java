package lambda;

public interface InterfaceTest {
	default void test(){
		System.out.println("test");
	}
	static void test2(){}//java8 public 
	static class A{
	}
}
