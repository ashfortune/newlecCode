package com.newlecture.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		String xml="spring-settings2.xml";
		Object location = sce.getServletContext().getInitParameter("location");
		if(location != null)
			xml = String.valueOf(location);
		
		System.out.println("톰켓시작?");
		System.out.println("[OK]spring context loaded");
		ApplicationContext context
		= new ClassPathXmlApplicationContext(xml);
		sce
		.getServletContext()
		.setAttribute("context",context);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰켓종료?");
	}
}
