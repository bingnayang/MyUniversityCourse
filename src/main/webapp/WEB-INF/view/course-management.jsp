<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<!-- External CSS --> 
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet" >

<title>University</title>
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
							width="100" height="100"></li>
						<br>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/">Home</a></li>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/course-list">All
								Course List</a></li>
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
								href="${pageContext.request.contextPath}/admins/active-course-manage">Active Courses 
								Manage</a></li>
						</security:authorize>
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Admin Course Management</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-toolbar mb-2 mb-md-0">
							<security:authentication property="principal.username" />
							|
							<security:authentication property="principal.authorities" />
						</div>
					</div>
				</div>
				<!-- Edit / Delete Course Section-->
				<div class="card mb-2 bg-light">
					<div class="card-body">
						<h5 class="card-title">Edit/Delete Course</h5>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Code</th>
									<th scope="col">Name</th>
									<th scope="col">Credit</th>
									<th scope="col">College</th>
<!-- 									<th scope="col">Action</th> -->
								</tr>
								<c:forEach var="tempCourse" items="${courses}">
									<tr>
										<td>${tempCourse.code}</td>
										<td>${tempCourse.name}</td>
										<td>${tempCourse.credit}</td>
										<td>${tempCourse.college}</td>
<!-- 										<td>
											<a type="button" class="btn-sm btn-outline-info">EDIT</a> |
											<a type="button" class="btn-sm btn-outline-info">DELETE</a>
										</td> -->
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>

				<!-- Add New Course Section-->
				<div class="card bg-light">
					<div class="card-body">
						<h5 class="card-title">Add New Course</h5>
						<form:form
							action="${pageContext.request.contextPath}/admins/new_course"
							modelAttribute="course"
							method="POST">
							<div class="form-group">
								<label for="courseCode">Course Code</label> 
								<form:input class="form-control" path="code" required="required"/>
							</div>
							<div class="form-group">
								<label for="courseName">Course Name</label> 
								<form:input class="form-control" path="name" required="required"/>
							</div>
							<div class="form-group">
								<label for="courseCredit">Course Credit</label> 
								<form:select
									class="form-control" path="credit">
									<option value="3">3</option>
									<option value="4">4</option>
								</form:select>
							</div>
							<div class="form-group">
								<label for="courseCollege">College</label> 
								<form:select
									class="form-control" path="college">
									<option value="College of Education">College of
										Education</option>
									<option value="College of Sciences">College of
										Sciences</option>
									<option value="College of Nursing & Health">College of
										Nursing & Health</option>
									<option value="College of Business">College of
										Business</option>
									<option value="College of Liberal Arts & Social Sciences">College
										of Liberal Arts & Social Sciences</option>
								</form:select>
							</div>
							<button type="submit" class="btn btn-outline-primary btn-block">Submit</button>
						</form:form>
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
</body>
</html>