package generic;

import java.util.Arrays;

public class GenericMethodTest {
	private static <T>  void swap(T[] t,int from,int to){
		T tmp = t[from] ; 
		t[from] =t[to] ; 
		t[to] = tmp ;
	}
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6}  ;
		swap(arr, 0, 1);
		System.out.println(Arrays.toString(arr));
	}
}
