package homeworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowTest {
	static void f(String path) throws IOException{
		FileInputStream fis = new FileInputStream(path) ; 
		// do something ...
		fis.close(); 
	}
	static void g(String path) throws FileNotFoundException{
		File file = new File(path);
		if(!file.exists()){
			throw new FileNotFoundException(file.getAbsolutePath() + "not found!");
		}
		// do something like f() ; 
	}
}
