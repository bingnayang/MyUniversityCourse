package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		// Create model attribute to bind form data
		Course theCourse = new Course();
		theModel.addAttribute("course",theCourse);
		
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
	
	@PostMapping("/admins/new_course")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {

		// Save the course
		courseService.saveCourse(theCourse);
		
		return "redirect:/admins/course-manage";
	}
}
