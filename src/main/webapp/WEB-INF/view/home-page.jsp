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
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" 
	rel="stylesheet" >

<title>My University</title>
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
							href="${pageContext.request.contextPath}/course-list">All Course
								List</a></li>
						<security:authorize access="hasRole('STUDENT')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/students/register-course">Register
									Course</a></li>
						</security:authorize>
						<security:authorize access="hasRole('STUDENT')">
							<li class="nav-item mb-2"><a
							class="btn btn-outline-primary btn-block" href="${pageContext.request.contextPath}/students/academics">Academic
								</a>
							</li>
						</security:authorize>	
						<security:authorize access="hasRole('INSTRUCTOR')">
							<li class="nav-item mb-2"><a
								class="btn btn-outline-primary btn-block"
								href="${pageContext.request.contextPath}/instructors/post-grade">Post
									Grades</a></li>
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
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<security:authentication property="principal.username" />
						|
						<security:authentication property="principal.authorities" />
					</div>
				</div>
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h1 class="display-4">Welcome To My University</h1>
						<h2>${account.firstName} ${account.lastName}</h2>
						<p class="lead">Study Hard & Work Hard & Love Life</p>
					</div>
				</div>

				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-4 d-flex align-items-stretch">
							<div class="card">
								<img src="https://images.unsplash.com/photo-1535982330050-f1c2fb79ff78?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1267&q=80" class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">News</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
								</div>
							</div>
						</div>
						<div class="col-lg-4 d-flex align-items-stretch">
							<div class="card">
								<img src="https://images.unsplash.com/photo-1574170609519-d1d8d4b71f60?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80" class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">News</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
								</div>
							</div>
						</div>
						<div class="col-lg-4 d-flex align-items-stretch">
							<div class="card">
								<img src="https://images.unsplash.com/photo-1501503069356-3c6b82a17d89?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">News</h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
								</div>
							</div>
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