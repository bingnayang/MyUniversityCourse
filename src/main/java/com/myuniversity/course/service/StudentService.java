package com.myuniversity.course.service;

import java.util.List;

import com.myuniversity.course.entity.InProgressCourse;

public interface StudentService {

	List<InProgressCourse> getInProgressCourses(String accountName);

}
