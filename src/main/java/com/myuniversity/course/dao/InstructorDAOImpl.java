package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.ActiveCourse;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ActiveCourse> getInstructorActiveCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
