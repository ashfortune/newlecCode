package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/exam/list")
@MultipartConfig(
		fileSizeThreshold = 0,
		maxFileSize = 500*1024*1024,
		maxRequestSize = 1024*1024*1024
		)
	public class ListController extends HttpServlet {
		
		private List<Exam> list;
		
		@Autowired
		private ExamService service;
		
		public ListController() {
//			Repository<Exam> repository = new JDBCExamRepository();
//			service = new ExamService(repository);
//			service = context.getBean(Service);   //service = new ExamService(new JDBCExamRepository());
		}
	  
	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	
		  	response.setCharacterEncoding("UTF-8");
		  	response.setContentType("text/html;UTF-8");
	//	  	PrintWriter out = response.getWriter();	  		
			
		  	String[] colors ={};
		  	if(request.getParameterValues("c") != null)
		  		colors = request.getParameterValues("c");
		  		
	//	  	for(int i = 0;i<colors.length;i++)
	//	  		System.out.println(colors[i]);
		  	
		  	
		  	String page_ = request.getParameter("p");
		  	
			
		  	if (page_ != null && !page_.equals("all")) {
	            int page = Integer.parseInt(page_);
	            list = service.getList(page);
	            request.setAttribute("page", page);
	        } else {
	            list = service.getList();
	            request.setAttribute("page", "all");
	        }
			
			request.setAttribute("list", list);
			
			
//			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp").forward(request, response);
			
			
			
	  }
	  	@Override
	  		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  			Part imgPart = req.getPart("img");
	  			String imgName = imgPart.getSubmittedFileName(); // getName() 대신 getSubmittedFileName() 사용
	            InputStream is = imgPart.getInputStream();
	            
	            String realPath = req.getServletContext().getRealPath("/notice/upload");
	            System.out.println(realPath);
	  			
	            File pathFile = new File(realPath);
	            if(!pathFile.exists())
	            	pathFile.mkdirs();
	            
	            String path = realPath + File.separator + imgName;
	            FileOutputStream fos = new FileOutputStream(path);
	            
	            byte[] buf = new byte[1024];
	            for(int size = 0; (size= is.read(buf)) != -1;)
	            	fos.write(buf,0,size);
	            
	            System.out.println(imgName);
	//            resp.sendRedirect("list");
	            is.close();
	            fos.close();
	  		}
	
}
