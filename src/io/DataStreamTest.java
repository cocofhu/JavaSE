package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(4);
		dos.flush();
		dos.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		DataInputStream dis = new DataInputStream(bais);
		System.out.println(dis.readInt());
	}
}
