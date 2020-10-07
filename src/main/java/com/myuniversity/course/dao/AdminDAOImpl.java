package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InstructorAccount;
import com.myuniversity.course.entity.StudentAccount;
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

	@Override
	public List<StudentAccount> getStudentList() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query 
		Query<StudentAccount> theQuery = currentSession.createQuery("from StudentAccount", StudentAccount.class);
		// execute query and get result list
		List<StudentAccount> studentList = theQuery.getResultList();		
		// return the results
		return studentList;
	}

	@Override
	public List<InstructorAccount> getInstructorList() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query 
		Query<InstructorAccount> theQuery = currentSession.createQuery("from InstructorAccount", InstructorAccount.class);
		// execute query and get result list
		List<InstructorAccount> instructorList = theQuery.getResultList();		
		// return the results
		return instructorList;
	}



}
