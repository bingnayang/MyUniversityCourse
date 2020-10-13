package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.entity.ActiveCourse;

public interface InstructorService {
	public List<ActiveCourse> getInstructorActiveCourses(String accountName);

	public List<InProgressCourse> getCourseStudents(String theCode);
}
