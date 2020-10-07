package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;

public interface AccountDAO {
	public List<AdminAccount> getAccountInfo(String username);
}
