package com.myuniversity.course.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InstructorAccount;


@Repository
public class AccountDAOImpl implements AccountDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String getAccountFullName(String username, String userrole) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		String accountFullName = "";
		String firstName = "";
		String lastName = "";
		String query = "";
		
		switch (userrole) {
		case "[ROLE_INSTRUCTOR]":
			query = "from InstructorAccount name where name.userEmail = :email";
			Query<InstructorAccount> theQuery = currentSession.createQuery(query);
			theQuery.setParameter("email",username);
			List<InstructorAccount> courses = theQuery.getResultList();
			
			for(InstructorAccount temp: courses) {
				firstName = temp.getFirstName();
				lastName = temp.getLastName();
			}
			accountFullName =firstName +" "+lastName;
//			System.out.println("Full Name: "+accountFullName);
			break;
		case "[ROLE_STUDENT]":
//			accountFullName ="ROLE_STUDENT";
			break;	
		case "[ROLE_ADMIN]":
//			accountFullName ="ROLE_ADMIN";
			break;
		default:
//			accountFullName ="NULL";
			break;
		}
		
		return accountFullName;
	}
	


}
