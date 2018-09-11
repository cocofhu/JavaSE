package generic;

import java.util.Collection;

public class GenericTest5 {
	public static <T> T copy(Collection<? super T> dest,Collection<T> src){
		T last = null ;
		for (T t : src) {
			last = t ;
			dest.add(t);
		}
		return last ; 
	}
	public static void main(String[] args) {
		
	}
}
