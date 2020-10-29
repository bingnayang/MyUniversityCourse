package com.myuniversity.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myuniversity.course.entity.InProgressCourse;
import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.Course;
import com.myuniversity.course.entity.CourseGrade;
import com.myuniversity.course.service.AccountService;
import com.myuniversity.course.service.InstructorService;

@Controller
public class InstructorController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/instructors/post-grade")
	public String instructorPostGrade(Model theModel) {
		String accountName = getAccountName();
		List<ActiveCourse> instructorCoursesList = instructorService.getInstructorActiveCourses(accountName);
		theModel.addAttribute("instructorActiveCoursesList",instructorCoursesList);
		
		return "post-grade";
	}
	
	@GetMapping("/instructors/active-courses")
	public String activeCourses(Model theModel) {
		String accountName = getAccountName();
		List<ActiveCourse> instructorCoursesList = instructorService.getInstructorActiveCourses(accountName);
		theModel.addAttribute("instructorActiveCoursesList",instructorCoursesList);
		
		return "instructor-active-courses";
	}
	
	@GetMapping("/instructors/view-students")
	public String courseStudents(@RequestParam("activeCourseCode") String theCode, Model theModel) {
		String accountName = getAccountName();
		List<ActiveCourse> instructorCoursesList = instructorService.getInstructorActiveCourses(accountName);
		theModel.addAttribute("instructorActiveCoursesList",instructorCoursesList);
		
		System.out.println("Active course code: "+theCode);
		List<InProgressCourse> courseStudents = instructorService.getCourseStudents(theCode);
		theModel.addAttribute("courseStudents",courseStudents);
		theModel.addAttribute("courseCode",theCode);
		return "instructor-active-courses";
	}
	
	@GetMapping("/instructors/student-grades")
	public String viewStudentGrade(@RequestParam("activeCourseCode") String theCode,Model theModel) {
		String accountName = getAccountName();
		List<ActiveCourse> instructorCoursesList = instructorService.getInstructorActiveCourses(accountName);
		theModel.addAttribute("instructorActiveCoursesList",instructorCoursesList);
		
		System.out.println("Active course code: "+theCode);
		List<CourseGrade> courseStudentsList = instructorService.getCourseStudentList(theCode);
		theModel.addAttribute("courseStudentsList",courseStudentsList);
		
		CourseGrade postGrade = new CourseGrade();
		theModel.addAttribute("postGrade",postGrade);
		
		return "post-grade";
	}
	
	// Save grades to database
	@PostMapping("/instructors/post_students_grade")
	public String saveGrade(@ModelAttribute("postGrade") CourseGrade theCourseGrade) {
		System.out.println("Update Course Id: "+theCourseGrade.getId());
		System.out.println("Update Course Student: "+theCourseGrade.getStudent_name());
		System.out.println("Update Course Grade: "+theCourseGrade.getGrade());

		return "redirect:/instructors/post-grade";
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
