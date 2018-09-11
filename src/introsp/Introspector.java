package introsp;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class Introspector {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IntrospectionException {
		PEntity entity = Factory.getEntity();
		System.out.println(entity);
	}
}
