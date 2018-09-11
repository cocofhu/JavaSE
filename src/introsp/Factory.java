package introsp;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Factory {

	static{
		
	}
	public static PEntity getEntity() throws ClassNotFoundException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<?> clazz = Class.forName("introsp.PEntity");
		PEntity entity = (PEntity) clazz.newInstance();
		BeanInfo beanInfo = java.beans.Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			Method m = pds[i].getWriteMethod();
			if("id".equals(pds[i].getName())){
				m.invoke(entity, 1);
			}else if("name".equals(pds[i].getName())){
				m.invoke(entity, "abc");
			}else if("start".equals(pds[i].getName())){
				m.invoke(entity, true);
			}
			
			
		}
		return entity ;
	}
	
}
