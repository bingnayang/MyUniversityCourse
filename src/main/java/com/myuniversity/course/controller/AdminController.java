package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.Course;
import com.myuniversity.course.service.AdminService;
import com.myuniversity.course.service.CourseService;

@Controller
public class AdminController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private AdminService adminService;
	
	// Admins Page
	@GetMapping("/admins/course-manage")
	public String courseManage(Model theModel) {
		// Get course list
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses",theCourses);		
		// Create model attribute to bind form data
		Course theCourse = new Course();
		theModel.addAttribute("course",theCourse);
		return "course-management";
	}
	@GetMapping("/admins/student-manage")
	public String studentManage() {
		return "student-management";
	}
	@GetMapping("/admins/instructor-manage")
	public String instructorManage() {
		return "instructor-management";
	}
	
	@GetMapping("/admins/active-course-management")
	public String activeCourseManage(Model theModel) {
		// Get active course list
		List<ActiveCourse> activeCourses = adminService.getActiveCourseList();
//		System.out.println("Admin Controller: ");
//		for(ActiveCourse i: activeCoursesList) {
//			System.out.println(i.getCode()+" | "+i.getInstructor()+" | "+i.getTime()+" | "+i.getDay());
//		}
		theModel.addAttribute("activeCourse", activeCourses);
		return "active-course-management";
	}
	
	// Save new course to database
	@PostMapping("/admins/new_course")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		// Save the course
		courseService.saveCourse(theCourse);
		return "redirect:/admins/course-manage";
	}
}
