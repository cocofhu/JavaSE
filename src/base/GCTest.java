package base;

public class GCTest {
	public static void main(String[] args){
		new GCTest();
		System.gc();
	}
	public void finalize(){
		System.out.println("GC");
	}
}
