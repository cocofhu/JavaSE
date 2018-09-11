package lambda;

public class CommadTest {
	static interface Command{
		void test(int a );
	}
	public static void main(String[] args) {
		/**
		 *  形参列表可以省略类型,如果形参列表只有一个参数,圆括号可以省略
		 *  代码块 如果代码块只包含一条语句,则可以省略大括号 只有一条语句时可以省略return
		 */
		Command cmd = a->System.out.println(a);
		cmd.test(11);
	}
}
 