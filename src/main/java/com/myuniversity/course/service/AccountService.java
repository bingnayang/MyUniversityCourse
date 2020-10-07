package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;

public interface AccountService {
	public List<AdminAccount> getAccountInfo(String username);
}
