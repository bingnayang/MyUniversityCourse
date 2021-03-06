package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.Course;

public interface CourseDAO {
	public List<Course> getCourses();
	public void saveCourse(Course theCourse);
	public List<ActiveCourse> getActiveCourses();

}
