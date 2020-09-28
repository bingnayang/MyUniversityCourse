package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.Account;
import com.myuniversity.course.entity.Course;
import com.myuniversity.course.service.AccountService;
import com.myuniversity.course.service.CourseService;


@Controller
public class UniversityAppController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		Account account = new Account();
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		// Get account info by signin username
		List<Account> accountInfo = accountService.getAccountInfo(username);
		// Save accoountInfo to Account object
		for(Account i: accountInfo) {
			// Use setter to set Account values and capitalize first letter of the name
			account.setFirstName(i.getFirstName().toUpperCase().charAt(0)+i.getFirstName().substring(1,i.getFirstName().length()));
			account.setLastName(i.getLastName().toUpperCase().charAt(0)+i.getLastName().substring(1,i.getLastName().length()));
		}
		theModel.addAttribute("account",account);
		return "home-page";
	}
	
	@GetMapping("/course-list")
	public String listCourses(Model theModel) {
		// Get course list from the courseService
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);
		return "course-list";
	}

//	
//	@GetMapping("/instructors")
//	public String instructorPage() {
//		return "instructors";
//	}
	
}
