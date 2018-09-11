package base;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	static class A<T>{
		public static int a = 100 ; 
	}
	public static void main(String[] args) {
		List array = new ArrayList();
		array.add("asd");
		List<Integer> ints = array;
		System.out.println(ints.get(0).floatValue());
		
	}
}
