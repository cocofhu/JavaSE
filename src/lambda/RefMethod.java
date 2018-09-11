package lambda;

public class RefMethod {
	static interface A{ 
		abstract int test(String str);
	}
	public static void main(String[] args) {
		A a = Integer::valueOf  ;
		A a1 = (new A() {
			@Override
			public int test(String str) {
				return 0;
			}
		})::test;
	}
}
