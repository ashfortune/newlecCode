package com.newlecture.di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.service.ExamService;

public class App2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ApplicationContext context
			= new AnnotationConfigApplicationContext("com.newlecture.web");
		ExamService service = context.getBean(ExamService.class);
		List<Exam> list = service.getList();
		System.out.println(list);
		
		/*
		Repository<Exam> rep = context.getBean(Repository.class);
		List<Exam> list = rep.findAll();
//		System.out.println(list);
		String realPath;
		{
			String pack = "com.newlecture.web.repository";
			String path = pack.replace(".","/");  //"com/newlectue/web/repository";
			
			ClassLoader classLoader = App2.class.getClassLoader();
			
			realPath = classLoader.getResource(path).getFile().toString();
			realPath = realPath.substring(1,realPath.length());
			
			System.out.println(realPath);
			
			//    com/newlecture/web/repository/FileExamRepository.class
//			Class cls = classLoader.loadClass(path);
			
			
			//Class 정보 객체를 얻는 방법 4가지
			
			Exam exam = new Exam();
			exam.getClass();
			Exam.class;
			Class.forName("com.newlecture.web.entity.Exam");
			App2.class.getClassLoader().loadClass("");
			
		}
		
		//디렉토리 목촐 출력
		{
//			String path = "C:\\8th\\WebWork\\javaprj\\src\\main\\java\\com\\newlecture";
			File directory = new File(realPath);
			File[] files = directory.listFiles();
			String type;
			for(File f : files) {
				type = "File";
				if(f.isDirectory())
					type = "Directory";
				System.out.printf("%s:%s\n",type,f.getName());
			}
			
		}
		*/
	}

}
