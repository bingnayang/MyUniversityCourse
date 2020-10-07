package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.ActiveCourse;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ActiveCourse> getInstructorActiveCourses(AdminAccount account) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		String firstName = account.getFirstName();
		String lastName = account.getLastName();
		String fullName = firstName+" "+lastName;
		
		String hql = "from ActiveCourse a where a.instructor = :instructor";
		// create a query 
		Query<ActiveCourse> theQuery = currentSession.createQuery(hql, ActiveCourse.class);
		theQuery.setParameter("instructor",fullName);
		
		// execute query and get result list
		List<ActiveCourse> courses = theQuery.getResultList();
		for(ActiveCourse i: courses) {
			System.out.println(i.getId());
			System.out.println(i.getCode());
			System.out.println(i.getInstructor());
			System.out.println(i.getTime());
			System.out.println(i.getDay());
		}		
		// return the results		
		return courses;
	}

}
