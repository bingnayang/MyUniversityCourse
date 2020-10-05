package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.Account;
import com.myuniversity.course.entity.ActiveCourse;

public interface InstructorService {
	public List<ActiveCourse> getInstructorActiveCourses(Account account);
}
