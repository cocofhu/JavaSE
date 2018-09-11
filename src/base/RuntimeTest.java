package base;

public class RuntimeTest {
	public static void main(String[] args){
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.availableProcessors());
		System.out.println(rt.freeMemory()/1024/1024);
		System.out.println(rt.totalMemory()/1024/1024);
		System.out.println(rt.maxMemory()/1024/1024);
	}
}
