package homeworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.Test;

public class UseCollection {
	static class A{
		@Override
		public int hashCode() {
			System.out.println("h");
			return super.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			System.out.println("e");
			return super.equals(obj);
		}
	}
	@Test
	public void f()
	{
		Set<A> s = new HashSet<UseCollection.A>();
		s.add(new A());
		s.add(new A());
	}
	public void g(){
		String str1 = "A" ;String str2 = "A" ;
		Set<String> s = new HashSet<>();
		s.add(str2);
		s.add(str1);
		System.out.println(s.size());
	}
	public static  void useSet(Set<Object> s){
		s.add(1);
		s.add(2);
		s.add(3);
		s.stream().forEach(System.out::println);
	}
	public static void useMap(Map<Object, Object> m){
		m.put(1, 1);
		m.put(2, 3);
		m.put(3, 3);
		m.forEach((a,b)->{
			System.out.println(a + "<->" + b);
		});
	}
	public static void useList(List<Object> l){
		l.add(1) ;
		l.add(2) ;
		l.add(3) ;
		l.stream().forEach(System.out::println);
	}
	public static void main(String[] args) {
		useSet(new ConcurrentSkipListSet<>());
		useSet(new HashSet<>());
		useSet(new TreeSet<>());
		useMap(new HashMap<Object, Object>());
		useMap(new ConcurrentHashMap<Object, Object>());
		useList(new ArrayList<Object>());
		useList(new LinkedList<Object>());
	}
}
