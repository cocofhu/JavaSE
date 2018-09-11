package generic;

public class GenericTest3 {
	static class A<T extends Number>{
		T n ;
	}
	public static void main(String[] args) {
		
	}
	/**
	 * 指定下限可以被赋值
	 */
	private static void print(A<? super Integer> a) {
		a.n = 3 ; 
	}
}
