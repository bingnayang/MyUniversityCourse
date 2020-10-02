package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.ActiveCourse;

public interface AdminDAO {

	List<ActiveCourse> getActiveCourse();

}
