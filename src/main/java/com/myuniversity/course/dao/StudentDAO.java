package com.myuniversity.course.dao;

import java.util.List;

import com.myuniversity.course.entity.InProgressCourse;

public interface StudentDAO {

	List<InProgressCourse> getInProgressCourses(String accountName);

}
