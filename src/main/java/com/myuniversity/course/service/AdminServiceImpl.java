package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.AdminDAO;
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

}
