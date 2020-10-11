package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.ActiveCourse;
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

		String fullName = getAccountName();		
		System.out.println("Full Name: "+fullName);
		theModel.addAttribute("fullName",fullName);
		return "home-page";
	}
	
	@GetMapping("/course-list")
	public String listCourses(Model theModel) {

		// Get course list from the courseService
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);
		// Get active course list from the courseService
		List<ActiveCourse> theActiveCourses = courseService.getActiveCourses();
		theModel.addAttribute("activeCourses",theActiveCourses);
		return "course-list";
	}
	
	// Get login account full name
	public String getAccountName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		String userrole = "";
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  userrole = ((UserDetails)principal).getAuthorities().toString();
		} else {
		  username = principal.toString();
		  userrole = principal.toString();
		}
		  System.out.println("getAccountName() = UserName: "+username);
		  System.out.println("getAccountName() = UserRole: "+userrole);
		// Get account full name by signin username
		String accountFullName = accountService.getAccountFullName(username,userrole);
		System.out.println("getAccountName() = Full Name: "+accountFullName);
		return accountFullName;
	}
}
