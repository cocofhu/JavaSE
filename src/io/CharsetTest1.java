package io;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest1 {
	public static void main(String[] args) {
		SortedMap<String, Charset>  map = Charset.availableCharsets() ; 
		for (String str : map.keySet()) {
			System.out.println(str);
		}
		Charset c1 = Charset.forName("GBK");
		Charset c2 = Charset.forName("GBK");
		System.out.println(c1 == c2);
	}
}
