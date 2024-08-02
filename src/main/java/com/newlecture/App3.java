package com.newlecture;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.web.entity.Exam;

public class App3 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException {
		// 객체 생성
		{
//			CSVParser parser = new CSVParser();
			Exam exam = new Exam();
			exam.setName("ashfortune");
			exam.setKor(87);
			exam.setEng(68);
			exam.setMath(95);
			String csv = CSVParser.toCSV(exam);
			System.out.println(csv);
		}
		
//		{
//			String className = "com.newlecture.web.entity.Exam";
////			Exam exam = new Exam(); //객체생성방법1
//			String callMethodName = "setName";
//			String value = "ashfortune";
//			Object obj = (Exam) Class.forName(className).getDeclaredConstructor().newInstance(); //객체생성방법2
//			System.out.println(obj);
//			
//			//RTTI -> RunTimeTypeInformation
//			Class cls = obj.getClass();
//			Class cls2 = Exam.class;
//			Method[] methods =cls.getDeclaredMethods();
//			
//			for(Method m :methods) {
//				System.out.println(m.getName());
//				if(m.getName().equals(callMethodName)) {
////					System.out.println("hihi");
//					m.invoke(obj,value);
//				}
//			}
//			
////			obj.setKor(30);
//			System.out.println(obj);
//		}
	}
}
