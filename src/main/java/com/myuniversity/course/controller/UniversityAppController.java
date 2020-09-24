package com.myuniversity.course.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UniversityAppController {

	@GetMapping("/")
	public String showHome() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username;
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println(username);
		
		
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
	@GetMapping("/admins")
	public String adminPage() {
		return "admins";
	}
}
