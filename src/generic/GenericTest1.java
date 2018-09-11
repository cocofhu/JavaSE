package generic;

import java.io.Serializable;

public class GenericTest1 {
	@SuppressWarnings("hiding")
	static class A<T>{
		//static T t ; error
	}
	static class B<T> extends A<T>{}
	public static void main(String[] args) {
		A<String> a1 = new A<String>();
		A<Integer> a2 = new A<Integer>();
		System.out.println(a1.getClass() == a2.getClass());
	}
}
