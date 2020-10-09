package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.ActiveCourse;
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
		
		String hql = "from InProgressCourse a where a.student_name = :student_name";
		// create a query 
		Query<InProgressCourse> theQuery = currentSession.createQuery(hql, InProgressCourse.class);
		theQuery.setParameter("student_name",accountName);
		
		// execute query and get result list
		List<InProgressCourse> courses = theQuery.getResultList();
		
		return courses;
	}

}
