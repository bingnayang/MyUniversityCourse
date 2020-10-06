package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.ActiveCourse;

public interface AdminDAO {

	public List<ActiveCourse> getActiveCourse();

	public void saveActiveCourse(ActiveCourse theActiveCourse);

}
