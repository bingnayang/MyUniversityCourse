package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.InProgressCourse;

@Repository
public class StudentDAOImpl implements StudentDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<InProgressCourse> getInProgressCourses(String accountName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
		return null;
	}

}
