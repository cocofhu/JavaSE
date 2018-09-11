package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class FileLockTest {
	static void m1() throws IOException, InterruptedException{
		Path p = Paths.get("D:", "123.txt");
		FileChannel fc = FileChannel.open(p,EnumSet.of(StandardOpenOption.WRITE,StandardOpenOption.READ)) ; 
		FileLock fl = fc.lock() ; // 
		fl.release(); 
//		fc.close();
//		System.out.println("released lock !");
//		Thread.sleep(40000);
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Path p = Paths.get("D:", "123.txt");
		FileChannel fc = FileChannel.open(p,EnumSet.of(StandardOpenOption.WRITE,StandardOpenOption.READ)) ; 
		ByteBuffer b = ByteBuffer.allocate(20) ;
		b.put((byte) 12);
		b.flip();
		fc.write(b);
		fc.close();
	}
}
