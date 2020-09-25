package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.Account;

public interface AccountDAO {
	public List<Account> getAccountInfo(String username);
}
