package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InstructorAccount;
import com.myuniversity.course.entity.StudentAccount;
import com.myuniversity.course.entity.ActiveCourse;

public interface AdminDAO {

	public List<ActiveCourse> getActiveCourse();
	public void saveActiveCourse(ActiveCourse theActiveCourse);
	public List<StudentAccount> getStudentList();
	public List<InstructorAccount> getInstructorList();

}
