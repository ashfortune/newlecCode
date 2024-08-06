package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/index")
public class IndexController implements Controller{ 
//	private ExamService service;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/WEB-INF/view/index.jsp");
		mv.addObject("test","Hello");
		mv.addObject("test1","my");
		mv.addObject("test2","name");
		mv.addObject("test3","is");
		mv.addObject("test4","ashfortune.");
		mv.addObject("test5","My MBTI is ENTJ");
		
		return mv;
	}
}
		
