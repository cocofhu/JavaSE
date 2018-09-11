package generic;

public class GenericTest2 {
	static class A<T>{T info;}
	public static void main(String[] args) {
		A<Integer> a1 =new A<>();
		A<String> a2 = new A<>();
		// a1 = a2 ; error
		a1.info = 3 ;
		print(a1);
	}
	/**
	 * 指定上限不能被赋值
	 */
	private static void print(A<? extends Integer> a) {
		System.out.println(a.info);
		Integer o  = a.info ; // 多态 
		
	}
}
