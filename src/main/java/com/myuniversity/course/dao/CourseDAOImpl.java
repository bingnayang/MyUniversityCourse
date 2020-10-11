package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourses() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();	
		// create a query 
		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);
		// execute query and get result list
		List<Course> courses = theQuery.getResultList();		
		// return the results		
		return courses;
	}

	@Override
	public void saveCourse(Course theCourse) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// Save the course
		currentSession.save(theCourse);
	}

	@Override
	public List<ActiveCourse> getActiveCourses() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();	
		// create a query 
		Query<ActiveCourse> theQuery = currentSession.createQuery("from ActiveCourse", ActiveCourse.class);
		// execute query and get result list
		List<ActiveCourse> courses = theQuery.getResultList();	
		// return the results		
		return courses;
	}


}
