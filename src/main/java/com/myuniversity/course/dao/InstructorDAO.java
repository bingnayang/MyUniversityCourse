package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.Account;
import com.myuniversity.course.entity.ActiveCourse;

public interface InstructorDAO {
	List<ActiveCourse> getInstructorActiveCourses(Account account);
}
