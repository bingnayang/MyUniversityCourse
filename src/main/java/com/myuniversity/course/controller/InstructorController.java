package com.myuniversity.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.service.InstructorService;

@Controller
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/instructors/post-grade")
	public String instructorPostGrade() {
		return "post-grade";
	}
	
	@GetMapping("/instructors/active-courses")
	public String activeCourses() {
		return "instructor-active-courses";
	}
}
