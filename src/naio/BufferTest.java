package naio;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8) ; 
		for (int i = 0; i < 100; i++) {
			buff.put('a');
		}
		
	}
}
