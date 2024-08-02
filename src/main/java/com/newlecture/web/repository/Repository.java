package com.newlecture.web.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;

public interface Repository<T> {

	List<T> findAll() throws IOException;

	List<T> findPageList(int page) throws IOException;
	
//	List<T> findDetail() throws IOException;
	
	int save();
	int update();
}

