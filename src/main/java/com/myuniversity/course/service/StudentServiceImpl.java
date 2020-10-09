package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.StudentDAO;
import com.myuniversity.course.entity.InProgressCourse;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<InProgressCourse> getInProgressCourses(String accountName) {
		// TODO Auto-generated method stub
		return studentDAO.getInProgressCourses(accountName);
	}

}
