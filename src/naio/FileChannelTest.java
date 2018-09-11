package naio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File dst = new File("D:\\1.txt") ;
		try(
				RandomAccessFile raf = new RandomAccessFile(dst, "rw");
				FileChannel fc = raf.getChannel();
			){
			MappedByteBuffer buf = fc.map(FileChannel.MapMode.READ_WRITE,0,dst.length());
			System.out.println(buf.isDirect());
			buf.put("a".getBytes());
			buf.force();
//			fc.write(buf);
		}
		
	}
}
