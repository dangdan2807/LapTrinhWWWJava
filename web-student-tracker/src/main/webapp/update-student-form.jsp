<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Edit Student Info Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>

<body>
	<div id="wrapper">
		<div class="container-fluid">
			<div class="header pt-4 pb-4 font-weight-bold text-light bg-primary">
				<h1>Edit Student Info Form</h1>
			</div>
			<div class="control mt-2 mb-2">
				<a type="button" class="btn btn-primary"
					href="StudentControllerServlet">Back to Dashboard</a>
			</div>
			<form class="mb-8" action="StudentControllerServlet" method="POST">
				<input type="hidden" name="command" value="UPDATE">
				<div class="form-group">
					<label for="studentId">Student Id</label> <input type="text"
						name="studentId" class="form-control" id="studentId"
						value="${THE_STUDENT.id}" readonly />
				</div>
				<div class="form-group">
					<label for="firstName">First name</label> <input type="text"
						name="firstName" class="form-control" id="firstName"
						placeholder="Enter your first Name"
						value="${THE_STUDENT.firstName}" />
				</div>
				<div class="form-group">
					<label for="lastName">Last name</label> <input type="text"
						name="lastName" class="form-control" id="lastName"
						placeholder="Enter your last Name" value="${THE_STUDENT.lastName}" />
				</div>
				<div class="form-group">
					<label for="email">Email address</label> <input type="email"
						name="email" class="form-control" id="email"
						placeholder="Enter your email address"
						value="${THE_STUDENT.email}" />
				</div>
				<div class="form-group">
					<label for="imageUrl">Avatar url image</label> <input type="text"
						name="imageUrl" class="form-control" id="imageUrl"
						placeholder="Enter your avatar url"
						value="${THE_STUDENT.imageUrl}" onchange="imageUrlChanged();" />
				</div>
				<button type="submit" class="btn btn-primary" value="Save">Save</button>
				<a type="button" class="btn btn-danger"
					href="StudentControllerServlet">Cancel</a> 
				<img id="img-avatar"
					class="float-right rounded img-avatar" src="${THE_STUDENT.imageUrl}"
					alt="image avatar" width="100" height="100">
			</form>
		</div>
	</div>
	<script src="./js/script.js"></script>
</body>

</html>