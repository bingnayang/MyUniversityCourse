package com.myuniversity.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.CourseGrade;
import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.entity.ActiveCourse;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ActiveCourse> getInstructorActiveCourses(String accountName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "from ActiveCourse a where a.instructor = :instructor";
		// create a query 
		Query<ActiveCourse> theQuery = currentSession.createQuery(hql, ActiveCourse.class);
		theQuery.setParameter("instructor",accountName);
		
		// execute query and get result list
		List<ActiveCourse> courses = theQuery.getResultList();
//		for(ActiveCourse i: courses) {
//			System.out.println(i.getId());
//			System.out.println(i.getCode());
//			System.out.println(i.getInstructor());
//			System.out.println(i.getTime());
//			System.out.println(i.getDay());
//		}		
		// return the results		
		return courses;
	}

	@Override
	public List<InProgressCourse> getCourseStudents(String theCode) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "from InProgressCourse a where a.course_code = :course_code";
		// create a query 
		Query<InProgressCourse> theQuery = currentSession.createQuery(hql, InProgressCourse.class);
		theQuery.setParameter("course_code",theCode);
		
		// execute query and get result list
		List<InProgressCourse> courses = theQuery.getResultList();
		
		for(InProgressCourse i: courses) {
			System.out.println("Code: "+i.getCourse_code());
			System.out.println("Student: "+i.getStudent_name());
		}
		return courses;
	}

	@Override
	public List<CourseGrade> getStudentGrade(String theCode) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "from CourseGrade a where a.course_code = :course_code";
		// create a query 
		Query<CourseGrade> theQuery = currentSession.createQuery(hql, CourseGrade.class);
		theQuery.setParameter("course_code",theCode);
		
		// execute query and get result list
		List<CourseGrade> courses = theQuery.getResultList();
		
//		for(CourseGrade i: courses) {
//			System.out.println("Course Code: "+i.getCourse_code());
//			System.out.println("Student: "+i.getStudent_name());
//		}
		return courses;
	}

}
