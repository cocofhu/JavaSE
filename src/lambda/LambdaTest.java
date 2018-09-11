package lambda;

public class LambdaTest {
	@FunctionalInterface
	static interface TT{
		int fun();
	}
	public static void main(String[] args) {
		TT t = ()->3 ;
		t.fun();
	}
}
