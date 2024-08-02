package com.newlecture.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exam/detail")
public class Detail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ExamService service = new ExamService();
		List<Exam> list = new ArrayList<>();
//		list = service.getDetail();
	
		req.setAttribute("list",list);
		req.getRequestDispatcher("/WEB-INF/view/exam/detail.jsp").forward(req,resp);
	}

}
