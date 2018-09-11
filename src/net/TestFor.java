package net;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestFor {
	public static void main(String[] args) {
		Set<String> str =new CopyOnWriteArraySet<String>();
		str.add("asdasd");
		str.add("123123");
		for (String string : str) {
			str.remove(string) ;
		}
	}
}
