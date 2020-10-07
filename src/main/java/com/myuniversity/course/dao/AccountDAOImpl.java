package com.myuniversity.course.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myuniversity.course.entity.AdminAccount;


@Repository
public class AccountDAOImpl implements AccountDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<AdminAccount> getAccountInfo(String username) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "from Account a where a.userEmail = :username_email";
		Query query = currentSession.createQuery(hql);
		query.setParameter("username_email",username);
		
		List<AdminAccount> results = query.getResultList();
//			
		for(AdminAccount i: results) {
			System.out.println(i.getId());
			System.out.println(i.getFirstName());
			System.out.println(i.getLastName());
			System.out.println(i.getUserEmail());
		}
		// return the results		
		return results;
	}

}
