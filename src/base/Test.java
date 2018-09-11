package base;

import lambda.InterfaceTest;

public class Test {
	static void test(StringBuffer str){
		str.append("asd");
	}
	public static void main(String[] args) throws InterruptedException {
		new InterfaceTest.A();
		System.out.println(2e3);
		StringBuffer sb = new StringBuffer() ;
		test(sb);
		System.out.println(sb);
		//Thread.currentThread().join();
	}
}
