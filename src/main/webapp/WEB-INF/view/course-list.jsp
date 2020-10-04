<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<!-- Font-Awesome CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
	crossorigin="anonymous" />
<!-- External CSS --> 
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet" >
<title>Course List</title>
</head>
<body>
	<nav
		class="navbar navbar-dark sticky-top bg-primary flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#"> <i
			class="fas fa-graduation-cap"></i> University
		</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-toggle="collapse" data-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><form:form
					class="form-inline my-2 my-lg-0"
					action="${pageContext.request.contextPath}/logout" method="POST">
					<input type="submit" value="Logout"
						class="btn btn-outline-light my-2 my-sm-0">
				</form:form></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse"
				style="padding-left: 5px; padding-right: 5px;">
				<div class="sidebar-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><img
							class="rounded mx-auto d-block img-thumbnail"
							alt="Responsive image"
							src="https://t4.ftcdn.net/jpg/02/17/96/11/240_F_217961105_JjZe7sYxJHh1cGNz2Re92SOAXZr8GvQP.jpg"
							width="100" height="100">
						</li>
						<br>
						<li><h5 class="text-center">Hi, ${account.firstName} ${account.lastName}</h5></li>
						<br>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/">Home</a></li>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/course-list">University Courses
								List</a></li>
						<security:authorize access="hasRole('STUDENT')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/students/register-course">Register
									Course</a></li>
						</security:authorize>
						<security:authorize access="hasRole('STUDENT')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/students/active-courses">Active
									Courses</a></li>
						</security:authorize>
						<security:authorize access="hasRole('STUDENT')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block" 
								href="${pageContext.request.contextPath}/students/academics">Academic
								</a>
							</li>
						</security:authorize>	
						<security:authorize access="hasRole('INSTRUCTOR')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/instructors/post-grade">Post
									Grades</a></li>
						</security:authorize>
						<security:authorize access="hasRole('INSTRUCTOR')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/instructors/active-courses">Active 
								Courses</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ADMIN')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/admins/course-manage">Course 
								Manage</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ADMIN')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/admins/student-manage">Student 
								Manage</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ADMIN')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/admins/instructor-manage">Instructor 
								Manage</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ADMIN')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/admins/active-course-management">Active Courses 
								Manage</a></li>
						</security:authorize>
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">University Courses List</h1>
					<h5>${account.firstName} ${account.lastName}</h5>
					<div class="btn-toolbar mb-2 mb-md-0">					
						<security:authentication property="principal.username"/> | <security:authentication property="principal.authorities"/>
					</div>
				</div>
				<div>
					<hr>
					<div class="container-fluid">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">Code</th>
									<th scope="col">Name</th>
									<th scope="col">Credit</th>
									<th scope="col">College</th>
								</tr>
								<c:forEach var="tempCourse" items="${courses}">
									<tr>
										<td>${tempCourse.code}</td>
										<td>${tempCourse.name}</td>
										<td>${tempCourse.credit}</td>
										<td>${tempCourse.college}</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>

			</main>
		</div>
	</div>
	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>