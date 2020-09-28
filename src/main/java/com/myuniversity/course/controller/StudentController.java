package com.myuniversity.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	
	@GetMapping("/students/register-course")
	public String studentPage() {
		return "register-course";
	}
	@GetMapping("/students/academics")
	public String studentAcademics() {
		return "academics";
	}
}
