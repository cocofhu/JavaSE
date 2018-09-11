package base;
import java.lang.ref.*;
import java.lang.reflect.Field;/*
public class ReferenceTest{
	public static void main(String[] args){
		String str = new String("AAAAAAAAAAA");
		WeakReference wr = new WeakReference(str);
		str = null ; 
		System.out.println(wr.get());
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
}*/
public class ReferenceTest {
    public static boolean isRun = true;

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        new Thread() {
            public void run() {
                while (isRun) {
                    PhantomReference obj = (PhantomReference)referenceQueue.poll();
                    if (obj != null) {
                        try {
                            /*Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(obj);
                            System.out.println("gc will collect："
                                    + result.getClass() + "@"
                                    + result.hashCode() + "\t"
                                    + (String) result);*/
							System.out.println(obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,
                referenceQueue);
		System.out.println(abcWeakRef);		
        abc = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        isRun = false;
    }
}