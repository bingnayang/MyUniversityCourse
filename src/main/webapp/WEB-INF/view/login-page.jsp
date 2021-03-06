<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Insert title here</title>
</head>
<style>
html, body {
	height: 100%
}
</style>
<body class="bg-light">
	<!-- Nav section -->
	<nav class="navbar navbar-light" style="background: #1F3944;">
		<a class="navbar-brand text-light" href="#"> <i class="fas fa-graduation-cap"></i>
			University
		</a>
	</nav>
	<!-- Login section -->
	<div class="h-100 row align-items-center" style="background: #1F3944;">
		<div class="col">
			<div class="card container"
				style="width: 28rem;">
				<div class="card-body">
					<h5 class="card-title text-center mb-5">
						<i class="fas fa-graduation-cap fa-4x" style="color: #1F3944;"></i>
					</h5>
					<h5 class="card-title text-center mb-5">LOG IN</h5>
					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="User Name"
								name="username" required="required"/>
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="Password" name="password" required="required"/>
						</div>
						<div class="form-group text-center">
							<!-- Display error if user input username/password -->
							<c:if test="${param.error != null}">
								<div class="alert alert-danger" role="alert">
								Wrong username/password</div>
							</c:if>
							<!-- Display check out message -->
							<c:if test="${param.logout != null}">
								<div class="alert alert-primary" role="alert">
								You Have Been Logged Out</div>
							</c:if>
						</div>
						<button type="submit" class="btn btn-block text-light" style="background: #1F3944;">Submit</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>