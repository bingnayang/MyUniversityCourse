package com.myuniversity.course.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myuniversity.course.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account getAccountInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
