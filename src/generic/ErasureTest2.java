package generic;

import java.util.ArrayList;
import java.util.List;

public class ErasureTest2 {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(6) ;
		li.add(9) ;
		List list = li ; 
		List<String> ls = list ; // OK
		System.out.println(ls.get(0)); // 用的时候回出错
	}
}
