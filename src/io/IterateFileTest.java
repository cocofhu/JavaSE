package io;

import java.io.File;

public class IterateFileTest {
	public static void iter(File root){
		if(root.isDirectory()){
			File[] files = root.listFiles();
			if(files != null )
			for (int i = 0; i < files.length; i++) {
				iter(files[i]);
			}
		}
		else System.out.println(root.getAbsolutePath());
	}
	public static void main(String[] args) {
		iter(new File("D:\\"));
	}
}
