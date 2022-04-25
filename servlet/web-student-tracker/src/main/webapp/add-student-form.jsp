<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Add student form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
</head>

<body>
	<div class="container-fluid">
		<div class="header">
			<h1>Add Student Form</h1>
		</div>
		<div class="control">
			<a type="button" class="btn btn-primary"
				href="StudentControllerServlet">Quay lại DS lớp</a>
			<c:url var="backToClass" value="StudentControllerServlet">
				<c:param name="command" value="LOAD_LIST_STUDENT"></c:param>
				<c:param name="classId" value="${CLASS_ID}"></c:param>
			</c:url>
			<a type="button" class="btn btn-primary" href="${backToClass}">Quay
				lại DSSV</a>
		</div>
		<div class="container">
			<form id="form-add-student" action="StudentControllerServlet"
				method="POST">
				<input type="hidden" name="command" value="ADD_STUDENT"> <input
					type="hidden" name="classId" value="${CLASS_ID}">
				<div class="row">
					<div class="col-xl-8">
						<div class="form-group">
							<label for="firstName">First name</label> <input type="text"
								name="firstName" class="form-control" id="firstName"
								placeholder="Enter your first Name" required>
						</div>

						<div class="form-group">
							<label for="lastName">Last name</label> <input type="text"
								name="lastName" class="form-control" id="lastName"
								placeholder="Enter your last Name" required>
						</div>

						<div class="form-group">
							<label for="gender">Gender:</label> <br />
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="male" value="0" checked> <label
									class="form-check-label" for="male">Nam</label>
							</div>

							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"
									id="female" value="1"> <label class="form-check-label"
									for="female">Nữ</label>
							</div>
						</div>

						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								name="email" class="form-control" id="email"
								placeholder="Enter your email address" required>
						</div>

						<div class="form-group">
							<label for="class">Class:</label> <select id="class" name="class"
								class="form-control">
								<option selected>Choose...</option>
								<c:forEach var="tempClass" items="${CLASS_LIST}">
									<option value="${tempClass.classId}"
										<c:if test="${CLASS_ID == tempClass.classId}">
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
								<img id="img-avatar" class="float-right img-avatar" src=""
									alt="" hidden>
							</div>
						</div>

						<div class="form-group">
							<label for="imageUrl">Avatar url image</label> <input type="text"
								name="imageUrl" class="form-control" id="imageUrl"
								placeholder="Enter your avatar url"
								onchange="imageUrlChanged();" />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary" value="Save">Add
					student</button>
				<a type="button" class="btn btn-danger" href="${backToClass}">Cancel</a>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/script.js"></script>
</body>

</html>