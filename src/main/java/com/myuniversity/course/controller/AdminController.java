package com.myuniversity.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myuniversity.course.entity.AdminAccount;
import com.myuniversity.course.entity.ActiveCourse;
import com.myuniversity.course.entity.Course;
import com.myuniversity.course.entity.InstructorAccount;
import com.myuniversity.course.entity.StudentAccount;
import com.myuniversity.course.service.AdminService;
import com.myuniversity.course.service.CourseService;

@Controller
public class AdminController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private AdminService adminService;

	
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
	public String studentManage(Model theModel) {
		List<StudentAccount> studentList = adminService.getStudentList();
		theModel.addAttribute("studentList", studentList);
		return "student-management";
	}
	
	@GetMapping("/admins/instructor-manage")
	public String instructorManage(Model theModel) {
		List<InstructorAccount> instructorList = adminService.getInstructorList();
		theModel.addAttribute("instructorList", instructorList);
		return "instructor-management";
	}
	
	@GetMapping("/admins/active-course-management")
	public String activeCourseManage(Model theModel) {
		// Get active course list
		List<ActiveCourse> activeCourses = adminService.getActiveCourseList();
		theModel.addAttribute("activeCoursesManage", activeCourses);
		// Create model attribute to bind form data
		ActiveCourse theCourse = new ActiveCourse();
		theModel.addAttribute("activeCourseManage",theCourse); 
		// Get course code list
		List<Course> theCourseCode = courseService.getCourses();
		theModel.addAttribute("theCourseCode",theCourseCode);
		return "active-course-management";
	}

	// Save new course to database
	@PostMapping("/admins/new_course")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		// Save the course
		courseService.saveCourse(theCourse);
		return "redirect:/admins/course-manage";
	}
	
	// Save new active course to database
	@PostMapping("/admins/new_active_course")
	public String saveActiveCourse(@ModelAttribute("active-course") ActiveCourse theActiveCourse) {
		// For testing
//		System.out.println(theActiveCourse.getCode());
//		System.out.println(theActiveCourse.getInstructor());
//		System.out.println(theActiveCourse.getTime());
//		System.out.println(theActiveCourse.getDay());
		
//		adminService.saveActiveCourse(theActiveCourse);
		
		return "redirect:/admins/active-course-management";
	}
}
