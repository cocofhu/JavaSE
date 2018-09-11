package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;

public class CharsetTest {
	public static void main(String[] args) throws IOException {
		Charset gbk = Charset.forName("GBK") ;
		Charset utf8 = Charset.forName("utf-8") ;
		Path p = Paths.get("D:\\123.txt");
		FileChannel fc = FileChannel.open(p,EnumSet.of(StandardOpenOption.READ),new FileAttribute<?>[0]) ; 
		MappedByteBuffer bb =  fc.map(MapMode.READ_ONLY, 0, p.toFile().length()) ; 
		CharBuffer cb = gbk.decode(bb) ; 
		Path p2 = Paths.get("D:\\222.txt");
		FileChannel fc2 = FileChannel.open(p2,EnumSet.of(StandardOpenOption.WRITE,StandardOpenOption.CREATE),new FileAttribute<?>[0]) ; 
		fc2.write(utf8.encode(cb));
	}
}
