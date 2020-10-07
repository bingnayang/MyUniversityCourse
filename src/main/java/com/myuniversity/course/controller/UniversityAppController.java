package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.AdminAccount;
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
//		AdminAccount account = getAccountName();		
//		theModel.addAttribute("account",account);
		return "home-page";
	}
	
	@GetMapping("/course-list")
	public String listCourses(Model theModel) {
		// Get Account use name
		AdminAccount account = getAccountName();
		// Get course list from the courseService
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);
		theModel.addAttribute("account",account);
		return "course-list";
	}
	
	// Get login account full name
	public AdminAccount getAccountName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		String userrole;
		AdminAccount account = new AdminAccount();
		
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
		List<AdminAccount> accountInfo = accountService.getAccountInfo(username);
		// Save accoountInfo to Account object
		for(AdminAccount i: accountInfo) {
			// Use setter to set Account values and capitalize first letter of the name
			account.setFirstName(i.getFirstName().toUpperCase().charAt(0)+i.getFirstName().substring(1,i.getFirstName().length()));
			account.setLastName(i.getLastName().toUpperCase().charAt(0)+i.getLastName().substring(1,i.getLastName().length()));
		}
		return account;
	}
}
