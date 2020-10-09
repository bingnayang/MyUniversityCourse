package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.InstructorAccount;
import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.service.AccountService;
import com.myuniversity.course.service.InstructorService;

@Controller
public class InstructorController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/instructors/post-grade")
	public String instructorPostGrade() {
		return "post-grade";
	}
	
	@GetMapping("/instructors/active-courses")
	public String activeCourses(Model theModel) {
		String accountName = getAccountName();
		List<ActiveCourse> instructorCoursesList = instructorService.getInstructorActiveCourses(accountName);
		theModel.addAttribute("instructorActiveCoursesList",instructorCoursesList);
		return "instructor-active-courses";
	}
	
	// Get login user full name
	public String getAccountName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		String userrole = "";
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  userrole = ((UserDetails)principal).getAuthorities().toString();
		  System.out.println("UserName: "+username);
		  System.out.println("UserRole: "+userrole);
		} else {
		  username = principal.toString();
		  userrole = principal.toString();
		}
		// Get account full name by signin username
		String accountFullName = accountService.getAccountFullName(username,userrole);

		return accountFullName;
	}
}
