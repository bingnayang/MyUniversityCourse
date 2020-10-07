package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.AdminDAO;
import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.ActiveCourse;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	@Transactional
	public List<ActiveCourse> getActiveCourseList() {
		return adminDAO.getActiveCourse();
	}

	@Override
	@Transactional
	public void saveActiveCourse(ActiveCourse theActiveCourse) {
		// TODO Auto-generated method stub
		adminDAO.saveActiveCourse(theActiveCourse);
	}

	@Override
	@Transactional
	public List<AdminAccount> getStudents() {
		// TODO Auto-generated method stub
		return adminDAO.getStudents();
	}



}
