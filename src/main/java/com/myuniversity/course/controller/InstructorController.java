package com.myuniversity.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorController {
	@GetMapping("/instructors/post-grade")
	public String instructorPostGrade() {
		return "post-grade";
	}
	@GetMapping("/instructors/active-courses")
	public String activeCourses() {
		return "instructor-active-courses";
	}
}
