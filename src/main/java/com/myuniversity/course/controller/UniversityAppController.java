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
		// Get Account use name
		Account account = getAccountName();		
		theModel.addAttribute("account",account);
		return "home-page";
	}
	
	@GetMapping("/course-list")
	public String listCourses(Model theModel) {
		// Get Account use name
		Account account = getAccountName();
		// Get course list from the courseService
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);
		theModel.addAttribute("account",account);
		return "course-list";
	}
	
	// Get login account full name
	public Account getAccountName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		String userrole;
		Account account = new Account();
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  userrole = ((UserDetails)principal).getAuthorities().toString();
		  System.out.println("UserName: "+username);
		  System.out.println("UserRole: "+userrole);
		} else {
		  username = principal.toString();
		  userrole = principal.toString();
		}
		// Get account info by signin username
		List<Account> accountInfo = accountService.getAccountInfo(username);
		// Save accoountInfo to Account object
		for(Account i: accountInfo) {
			// Use setter to set Account values and capitalize first letter of the name
			account.setFirstName(i.getFirstName().toUpperCase().charAt(0)+i.getFirstName().substring(1,i.getFirstName().length()));
			account.setLastName(i.getLastName().toUpperCase().charAt(0)+i.getLastName().substring(1,i.getLastName().length()));
		}
		return account;
	}
}
