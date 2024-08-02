package com.newlecture.web.repository.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;

public class JDBCExamRepository implements Repository<Exam>{

	@Override
	public List<Exam> findAll() throws IOException {
		List<Exam> list = new ArrayList();
		return list;
	}

	@Override
	public List<Exam> findPageList(int page) throws IOException {
		List<Exam> list = new ArrayList();
		return list;
	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public List<Exam> findDetail() throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
