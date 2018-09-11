package base;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String args[]){
		// static initialize
		//int[] arr1 = {1,2,3,5} ;
		int[] arr1 = new int[]{1,2,3,5};
		System.out.println(Arrays.toString(arr1));
		
		// dynamic initialize
		int[] arr2 = new int[4] ; 
		for(int k : arr2) System.out.println(k);
		// System.out.println(Arrays.toString(arr2));
		int[] arr3 = null ;
		System.out.println(arr3);
		int[][] arr4= {{1}};
		int[][] arr5 = new int[5][];
	}
}
