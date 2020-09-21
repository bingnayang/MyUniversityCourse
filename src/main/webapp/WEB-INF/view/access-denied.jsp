<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Page Access Denied</title>
</head>
<style>
html, body {
	height: 100%;
	background: #1F3944;
}
.fa-times-circle{
	color: red;
}
</style>
<body>
	<div class="h-100 row align-items-center">
		<div class="col">
			<div class="container">
				<div class="card text-center bg-light">
					<div class="card-body">
						<div class="container">
							<div class="row">
								<div class="col">
									<i class="fas fa-times-circle fa-8x"></i>
								</div>
								<div class="col">
									<h3 class="card-title">Access Denied</h3>
									<p class="card-text">You don't have permission to access this page</p>
									<a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/">Back To Home</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>