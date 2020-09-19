<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h4 class="text-center">Login</h4>
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

			<div class="form-group">
				<label for="userName">User Name</label> 
				<input type="text" class="form-control" placeholder="Enter User Name" name="username"/>
			</div>
			<div class="form-group">
				<label for="passWord">Password</label> 
				<input type="password" class="form-control" placeholder="Password" name="password"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>