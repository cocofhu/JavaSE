package io;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

public class CommonCompress {
	
	public static void main(String[] args) throws Exception{
		OutputStream out = Files.newOutputStream(Paths.get("D:\\123.zip")) ; 
		ArchiveOutputStream zout = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, out) ; 
		zout.putArchiveEntry(new ZipArchiveEntry("testdata/test1.chm"));
		IOUtils.copy(Files.newInputStream(Paths.get("D:\\123.chm")), zout);
		zout.closeArchiveEntry();
		zout.close();
	}
}
