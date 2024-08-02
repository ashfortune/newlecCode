package com.newlecture.web.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.FileExamRepository;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.repository.jdbc.JDBCExamRepository;

@Component
public class ExamService {
	
	@Autowired
	private Repository<Exam> repository;
	
	public ExamService() {
		// TODO Auto-generated constructor stub
	}
//	@Autowired 
	public void setRepository(Repository<Exam> repository) {
		this.repository = repository;
	}
	
	//DI
//	@Autowired
	public ExamService(Repository<Exam> repository) {
		this.repository = repository;
//		repository = new FileExamRepository();
//		repository = new JDBCExamRepository();
	}
	

	public List<Exam> getList(int page) throws IOException {
		List<Exam> list = repository.findPageList(page);
		return list;
	}
	
	public List<Exam> getList() throws IOException {
		List<Exam> list = repository.findAll();
		return list;
	}
	
//	public List<Exam> getDetail() throws IOException {
//		List<Exam> list = repository.findDetail();  
//		return list;
//	}
		
}
