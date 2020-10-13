package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.entity.ActiveCourse;

public interface InstructorDAO {
	List<ActiveCourse> getInstructorActiveCourses(String accountName);

	List<InProgressCourse> getCourseStudents(String theCode);
}
