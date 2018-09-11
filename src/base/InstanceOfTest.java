package base;

public class InstanceOfTest {
	public static void main(String[] args){
		Object hello = new String("asd");
		System.out.println(hello instanceof String);
		System.out.println(hello instanceof CharSequence);
		CharSequence a = (CharSequence)hello;  
		//System.out.println(a instanceof Math); error
	}
}
