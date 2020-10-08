package com.myuniversity.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myuniversity.course.dao.AccountDAO;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;
	

	@Override
	@Transactional
	public String getAccountFullName(String username, String userrole) {
		// TODO Auto-generated method stub
		return accountDAO.getAccountFullName(username,userrole);
	}

}
