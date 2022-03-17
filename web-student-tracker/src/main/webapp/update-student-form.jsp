<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit Student Info Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<style type="text/css">
body {
	font-family: 'Roboto', sans-serif;
}

.header {
	background-color: #007bff;
	padding: 1rem 0px;
}

.header>h1 {
	text-align: center;
	font-weight: bold;
	color: #fff;
}

.control {
	margin: 4px 0;
}

.form-group>label {
	font-weight: bold;
}

form .img-box {
	display: flex;
	width: 300px;
	height: 300px;
	margin-top: 2rem;
	margin-bottom: 4px;
}

form .img-avatar {
	width: 300px;
	height: 300px;
}

form a.btn ~ #img-avatar {
	margin-bottom: 8px;
}
</style>
</head>

<body>
	<div id="wrapper">
		<div class="container-fluid">
			<div class="header">
				<h1>Edit Student Info Form</h1>
			</div>
			<div class="control">
				<a type="button" class="btn btn-primary"
					href="StudentControllerServlet">Quay lại DS lớp học</a>
				<c:url var="backToClass" value="StudentControllerServlet">
					<c:param name="command" value="LOAD_LIST_STUDENT"></c:param>
					<c:param name="classId" value="${THE_STUDENT.classes.classId}"></c:param>
				</c:url>
				<a type="button" class="btn btn-primary" href="${backToClass}">Quay lại DSSV</a>
			</div>
			<div class="container">
				<form action="StudentControllerServlet" accept-charset="utf-8"
					method="POST">
					<input type="hidden" name="command" value="UPDATE_STUDENT">
					<input type="hidden" name="classId"
						value="${THE_STUDENT.classes.classId}">

					<div class="row">
						<div class="col-xl-8">
							<div class="form-group">
								<label for="studentId">Student Id:</label> <input type="text"
									name="studentId" class="form-control" id="studentId"
									value="${THE_STUDENT.id}" readonly />
							</div>

							<div class="form-group">
								<label for="firstName">First name:</label> <input type="text"
									name="firstName" class="form-control" id="firstName"
									placeholder="Enter your first Name"
									value="${THE_STUDENT.firstName}" required />
							</div>

							<div class="form-group">
								<label for="lastName">Last name:</label> <input type="text"
									name="lastName" class="form-control" id="lastName"
									placeholder="Enter your last Name"
									value="${THE_STUDENT.lastName}" required />
							</div>

							<div class="form-group">
								<label for="gender">Gender:</label> <br />
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="male" value="0"
										<c:if test="${not THE_STUDENT.gender}">checked</c:if>>
									<label class="form-check-label" for="male">Nam</label>
								</div>

								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="female" value="1"
										<c:if test="${THE_STUDENT.gender}">checked</c:if>> <label
										class="form-check-label" for="female">Nữ</label>
								</div>
							</div>

							<div class="form-group">
								<label for="email">Email address:</label> <input type="email"
									name="email" class="form-control" id="email"
									placeholder="Enter your email address"
									value="${THE_STUDENT.email}" required />
							</div>

							<div class="form-group">
								<label for="class">Class:</label> <select id="class"
									name="class" class="form-control">
									<option selected>Choose...</option>
									<c:forEach var="tempClass" items="${CLASS_LIST}">
										<option value="${tempClass.classId}"
											<c:if test="${THE_STUDENT.classes.classId == tempClass.classId}">
									selected
								</c:if>>
											${tempClass.className}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-xl-4">
							<div class="form-group">
								<div class="img-box rounded border">
									<img id="img-avatar" class="float-right img-avatar"
										src="${THE_STUDENT.imageUrl}" alt="">
								</div>
							</div>

							<div class="form-group">
								<label for="imageUrl">Avatar url image:</label> <input
									type="text" name="imageUrl" class="form-control" id="imageUrl"
									placeholder="Enter your avatar url"
									value="${THE_STUDENT.imageUrl}" onchange="imageUrlChanged();" />
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" value="Save">Save</button>
					<a type="button" class="btn btn-danger" href="${backToClass}">Cancel</a>
				</form>
			</div>
		</div>
	</div>
	<script src="./js/script.js"></script>
</body>

</html>