package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.CourseDAO;
import com.myuniversity.course.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDAO.getCourses();
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		// TODO Auto-generated method stub
		courseDAO.saveCourse(theCourse);
	}

}
