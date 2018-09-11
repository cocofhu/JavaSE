package lambda;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionEach {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>() ;
		c.add("A");
		c.add("B");
		c.add("C");
		c.add("D");
		c.forEach(s -> System.out.println(s));
		c.iterator().forEachRemaining(s -> System.out.println(s));
	}
}
