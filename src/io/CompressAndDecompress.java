package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;



public class CompressAndDecompress {
	public static void compress(File to,File from){
		try (
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(to));
				BufferedOutputStream bos = new BufferedOutputStream(out);	
			){
			zip(out,bos,from,new String());
			out.flush();
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void decompress(File to,File from){
		try (
				FileInputStream fis = new FileInputStream(from);
				ZipInputStream in = new ZipInputStream(fis);
			){
			ZipEntry entry = null ;
			while( ( entry = in.getNextEntry() ) != null ){
				if(entry.isDirectory()){
					System.out.println(entry.getName());
					new File(to.getAbsolutePath(), entry.getName()).mkdirs() ; 
				}else{
					File file = new File(to.getAbsolutePath(),entry.getName());
					file.getParentFile().mkdirs() ;
					byte[] bytes = new byte[1024] ; 
					int len = -1 ; 
					try(
							FileOutputStream out = new FileOutputStream(file) ;
							BufferedOutputStream bos = new BufferedOutputStream(out);
						){
						while((len = in.read(bytes)) != -1){
							bos.write(bytes, 0, len);
						}
						out.flush();
						bos.flush();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	private static void zip(ZipOutputStream out, BufferedOutputStream bos, File from,String base) throws IOException {
		if(from.isDirectory()){
			File[] files = from.listFiles() ; 
			if(files.length == 0){
				out.putNextEntry(new ZipEntry(base+File.separatorChar+from.getName()+File.separatorChar));
			}
			for (File file : files) {
				zip(out, bos, file,from.getName());
			}
		}else{
			out.putNextEntry(new ZipEntry(base+File.separatorChar+from.getName()));
			try(
					InputStream is = new FileInputStream(from);
					BufferedInputStream bis = new BufferedInputStream(is);
				){
				byte[] bytes = new byte[1024] ; 
				int len = -1 ; 
				while((len = bis.read(bytes)) != -1){
					bos.write(bytes, 0, len);
				}
				bos.flush();
			}
		}
	}
	public static void main(String[] args) {
		compress(new File("D:\\1.zip"), new File("D:\\123"));
		decompress(new File("D:\\213"), new File("D:\\1.zip"));
	}
}
