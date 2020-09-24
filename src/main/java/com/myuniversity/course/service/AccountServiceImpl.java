package com.myuniversity.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.AccountDAO;
import com.myuniversity.course.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	@Transactional
	public Account getAccountInfo() {
		return accountDAO.getAccountInfo();
	}

}
