package generic;

import java.util.Collection;

public class RightTest {
	static <T> void test(Collection<? extends T> from ,Collection<T> to){
		for (T t : from) {
			to.add(t);
		}
	} 
}
