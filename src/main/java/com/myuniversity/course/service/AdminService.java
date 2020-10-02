package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.ActiveCourse;

public interface AdminService {
	public List<ActiveCourse> getActiveCourseList();
}
