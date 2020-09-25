package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.Account;

public interface AccountService {
	public List<Account> getAccountInfo(String username);
}
