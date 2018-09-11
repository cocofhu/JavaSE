package io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

	public static void main(String[] args) {
		try (
				FileChannel in  = new FileInputStream("C:\\Users\\Pouee\\Downloads\\JDK帮助文档.CHM").getChannel();
				FileChannel out = new FileOutputStream("D:\\JDK帮助文档.CHM").getChannel();	
			){
			ByteBuffer buff = ByteBuffer.allocate(2048);
			while(in.read(buff)!=-1){
				buff.flip();
				out.write(buff);
				buff.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
