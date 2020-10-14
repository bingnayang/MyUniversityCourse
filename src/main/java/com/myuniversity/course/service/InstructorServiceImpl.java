package com.myuniversity.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myuniversity.course.dao.InstructorDAO;
import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.CourseGrade;
import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.entity.ActiveCourse;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<ActiveCourse> getInstructorActiveCourses(String accountName) {
		// TODO Auto-generated method stub
		return instructorDAO.getInstructorActiveCourses(accountName);
	}

	@Override
	@Transactional
	public List<InProgressCourse> getCourseStudents(String theCode) {
		// TODO Auto-generated method stub
		return instructorDAO.getCourseStudents(theCode);
	}

	@Override
	@Transactional
	public List<CourseGrade> getStudentGrade(String theCode) {
		// TODO Auto-generated method stub
		return instructorDAO.getStudentGrade(theCode);
	}

}
