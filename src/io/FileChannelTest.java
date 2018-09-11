package io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;

public class FileChannelTest {

	public static void main(String[] args) {
		File f = new File("I:\\1.zip");
		try(
				FileChannel in = new FileInputStream(f).getChannel() ;
				FileChannel out = new FileOutputStream("D:\\234.zip").getChannel() ; 
			) {
			MappedByteBuffer buff =  in.map(MapMode.READ_ONLY, 0, f.length());
			out.write(buff);
			buff.clear() ;
			Charset charset = Charset.forName("GBK");
			System.out.println(charset.decode(buff));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
