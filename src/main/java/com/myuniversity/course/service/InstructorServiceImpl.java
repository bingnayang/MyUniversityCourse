package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.InstructorDAO;
import com.myuniversity.course.entity.Account;
import com.myuniversity.course.entity.ActiveCourse;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<ActiveCourse> getInstructorActiveCourses(Account account) {
		// TODO Auto-generated method stub
		return instructorDAO.getInstructorActiveCourses(account);
	}

}
