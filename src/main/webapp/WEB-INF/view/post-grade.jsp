<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- External CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/dashboard.css"
	rel="stylesheet">
<title>Instructor Page</title>
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
						<li class="nav-item mb-2"><img
							class="rounded mx-auto d-block img-thumbnail"
							alt="Responsive image"
							src="https://t4.ftcdn.net/jpg/02/17/96/11/240_F_217961105_JjZe7sYxJHh1cGNz2Re92SOAXZr8GvQP.jpg"
							width="100" height="100"></li>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/">Home</a></li>
						<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block"
							href="${pageContext.request.contextPath}/course-list">
								University Courses List</a></li>
						<security:authorize access="hasRole('INSTRUCTOR')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/instructors/post-grade">Post
									Grades</a></li>
						</security:authorize>
						<security:authorize access="hasRole('INSTRUCTOR')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/instructors/active-courses">In-Progress
									Courses</a></li>
						</security:authorize>
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Post Grade</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<security:authentication property="principal.username" />
						|
						<security:authentication property="principal.authorities" />
					</div>
				</div>
				<div class="card bg-light mb-2">
					<div class="card-body">
						<div class="container-fluid">
							<table class="table">
								<thead class="thead-light">
									<tr>
										<th scope="col">Code</th>
										<th scope="col">Instructor Name</th>
										<th scope="col">Time</th>
										<th scope="col">Day</th>
										<th scope="col">Action</th>
									</tr>
									<c:forEach items="${instructorActiveCoursesList}"
										var="activeCourse">
										<!-- Construct an "view student link" with course code -->
										<c:url var="viewLink" value="/instructors/student-grades">
											<c:param name="activeCourseCode" value="${activeCourse.code}" />
										</c:url>
										<tr>
											<td>${activeCourse.code}</td>
											<td>${activeCourse.instructor}</td>
											<td>${activeCourse.time}</td>
											<td>${activeCourse.day}</td>
											<td><a
												class="btn btn-sm btn-outline-primary collapsible"
												type="button" href="${viewLink}">View Students</a></td>
										</tr>
									</c:forEach>
							</table>
						</div>
					</div>
				</div>

				<div class="card bg-light mb-2">
					<div class="card-body">
						<div class="container-fluid">
							<table class="table">
								<tr>
									<th scope="col">Student Name</th>
									<th scope="col">Final Grade</th>
								</tr>
								<c:forEach items="${courseStudents}" var="courseStudents">
									<tr>
										<td>${courseStudents.student_name}</td>
										<td><input type="text" class="form-control"></td>
									</tr>
								</c:forEach>
							</table>
						</div>
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