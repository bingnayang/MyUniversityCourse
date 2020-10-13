package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.service.AccountService;
import com.myuniversity.course.service.CourseService;
import com.myuniversity.course.service.StudentService;


@Controller
public class StudentController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/students/register-course")
	public String studentRegisterCourse(Model theModel) {
		
		// Create model attribute to bind form data
//		ActiveCourse registerCourse = new ActiveCourse();
//		theModel.addAttribute("registerCourse",registerCourse);
		// Get active course list from the courseService
		List<ActiveCourse> theActiveCourses = courseService.getActiveCourses();
		theModel.addAttribute("activeCourses",theActiveCourses);
		return "register-course";
	}
	@GetMapping("/students/academics")
	public String studentAcademics() {
		return "academics";
	}
	@GetMapping("/students/active-courses")
	public String activeCourses(Model theModel) {
		String accountName = getAccountName();
		List<InProgressCourse> studentInProgressCourse = studentService.getInProgressCourses(accountName);
		theModel.addAttribute("studentInProgressCourse",studentInProgressCourse);
		return "student-active-courses";
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
