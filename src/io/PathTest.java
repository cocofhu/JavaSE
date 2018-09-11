package io;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathTest {
	public static void main(String[] args) {
		Path p = Paths.get("D:\\");
		Iterator<Path> ps =  p.iterator() ;
		while(ps.hasNext()){
			System.out.println(ps.next());
		}
	}
}
