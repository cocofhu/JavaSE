package io;
import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8) ; 
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
		buff.put('a') ; 
		buff.put('b');
		buff.put('c');
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
		buff.flip();
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
		System.out.println(buff.get());
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
		System.out.println(buff.get(5));
		buff.clear();
		
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
	}

}
