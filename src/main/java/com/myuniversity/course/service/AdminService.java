package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.StudentAccount;
import com.myuniversity.course.entity.ActiveCourse;

public interface AdminService {
	public List<ActiveCourse> getActiveCourseList();

	public void saveActiveCourse(ActiveCourse theActiveCourse);

	public List<StudentAccount> getStudentList();


}
