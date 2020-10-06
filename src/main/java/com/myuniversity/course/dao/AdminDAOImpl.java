package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myuniversity.course.entity.ActiveCourse;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ActiveCourse> getActiveCourse() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query 
		Query<ActiveCourse> theQuery = currentSession.createQuery("from ActiveCourse", ActiveCourse.class);
		// execute query and get result list
		List<ActiveCourse> activeCourses = theQuery.getResultList();		
		// return the results
		return activeCourses;
	}

	@Override
	public void saveActiveCourse(ActiveCourse theActiveCourse) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// Save the course
		currentSession.save(theActiveCourse);
		
	}

}
