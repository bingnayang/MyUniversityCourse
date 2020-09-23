<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>
</head>
<body>
	<h3>Course List</h3>
	<hr>
	<div class="container">
		<table>
			<tr>
				<th>First Name</th>
				<th>First Name</th>
				<th>First Name</th>
			</tr>
			<c:forEach var="tempCourse" items="${courses}">
				<tr>
					<td>${tempCourse.code}</td>
					<td>${tempCourse.name}</td>
					<td>${tempCourse.credit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>