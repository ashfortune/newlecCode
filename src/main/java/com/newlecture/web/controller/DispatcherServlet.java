package com.newlecture.web.controller;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/" ,loadOnStartup = 1,initParams = {
	@WebInitParam(name="path",value ="/WEB-INF/app.properties"),
	@WebInitParam(name="spring",value ="/WEB-INF/spring-dispatcher.xml")
})

public class DispatcherServlet extends HttpServlet{
	
//	private Properties prop = new Properties();
	ApplicationContext app;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("spring");
		String realPath = config.getServletContext().getRealPath(path);
//		app = new ClassPathXmlApplicationContext(realPath);
		app = new ClassPathXmlApplicationContext(realPath);

		
//		try {
//			String realPath = config.getServletContext().getRealPath(path); 
////			System.out.println(realPath);
//			InputStream is = new FileInputStream(realPath);
//			prop.load(is);
////			System.out.println(prop);
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		 catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		Controller controller = (Controller) app.getBean(uri);
		
		if(controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		try {
			controller.handleRequest(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String className = prop.getProperty(uri);
//		if (className ==null)
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//		else
//			System.out.println(className);
//		
//		
//		String obj = (String) prop.get(uri);
		
		//객체화
//		Controller controller = clz.getConstructor().newInstance();
//		controller.service();
		
//		System.out.println("요청");
	}
}
