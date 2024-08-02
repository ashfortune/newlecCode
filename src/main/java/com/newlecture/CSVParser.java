package com.newlecture;


import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.annotations.Precision;
import com.newlecture.annotations.Transient;

public class CSVParser {

	public static <T> String toCSV(T entity) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		StringBuilder builder = new StringBuilder();
		Class cls = entity.getClass();
		
		{
			Field[] fields = cls.getDeclaredFields();
			for(Field f : fields) {
				if(f.isAnnotationPresent(Transient.class)) {
					f.setAccessible(true);
					Object value = f.get(entity);
				}
			}
		}
		
		{
			Method[] methods = cls.getDeclaredMethods();
			boolean isFirst = true;
			
			for(Method m : methods) {
				String name = m.getName();
				if(name.startsWith("get"))
					if(!m.isAnnotationPresent(Transient.class)) {
						Object value = m.invoke(entity,null);
						if(m.isAnnotationPresent(Precision.class)) {
							Precision precision = m.getAnnotation(Precision.class);
							int v = precision.value();
							int v1 = precision.val();
							String fmt = precision.format();
							value = String.format(fmt,value);
						}
						if(!isFirst) {
							builder.append(",");
						}
						builder.append(value);
						isFirst = false;
						
	//				if(m.isAnnotationPresent(Num.class))
	//					System.out.println(100);
					}
			}
				
			return builder.toString();
		}
	}
}
