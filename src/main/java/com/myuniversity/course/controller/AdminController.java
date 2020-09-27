package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.Course;
import com.myuniversity.course.service.CourseService;

@Controller
public class AdminController {
	@Autowired
	private CourseService courseService;
	
	// Admins Page
	@GetMapping("/admins/course-manage")
	public String courseManage(Model theModel) {
		// Get course list from the courseService
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);
		
		return "course-management";
	}
	@GetMapping("/admins/student-manage")
	public String studentManage() {
		return "student-management";
	}
	@GetMapping("/admins/instructor-manage")
	public String instructorManage() {
		return "instructor-management";
	}
}
