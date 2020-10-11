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
			query = "from StudentAccount name where name.userEmail = :email";
			Query<StudentAccount> theStudentQuery = currentSession.createQuery(query);
			theStudentQuery.setParameter("email",username);
			List<StudentAccount> studentCourses = theStudentQuery.getResultList();
			
			for(StudentAccount temp: studentCourses) {
				firstName = temp.getFirstName();
				lastName = temp.getLastName();
			}
			accountFullName =firstName +" "+lastName;
//			System.out.println("Full Name: "+accountFullName);
			break;	
		case "[ROLE_ADMIN]":
			query = "from AdminAccount name where name.userEmail = :email";
			Query<AdminAccount> theAdminQuery = currentSession.createQuery(query);
			theAdminQuery.setParameter("email",username);
			List<AdminAccount> adminCourses = theAdminQuery.getResultList();
			
			for(AdminAccount temp: adminCourses) {
				firstName = temp.getFirstName();
				lastName = temp.getLastName();
			}
			accountFullName =firstName +" "+lastName;
//			System.out.println("Full Name: "+accountFullName);
			break;
		default:
			break;
		}
		
		return accountFullName;
	}
	


}
