package com.myuniversity.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

	@GetMapping("/")
	public String showHome() {
		return "home-page";
	}
	
	@GetMapping("/students")
	public String studentPage() {
		return "students";
	}
	
	@GetMapping("/instructors")
	public String instructorPage() {
		return "instructors";
	}
}
