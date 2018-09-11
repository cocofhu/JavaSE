package jdbc;
import java.io.Closeable;
import java.io.IOException;

public class CloseableTest {

	public static void main(String[] args) {
		try (
				CT c = new CT();
			){
			c.test();
			return ;
			//throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("An Exception occurred");
		}
	}
	
}
class CT implements Closeable{

	@Override
	public void close() throws IOException {
		System.out.println("Closing...");
	}
	public void test(){
		System.out.println("inspecting...");
	}
}
