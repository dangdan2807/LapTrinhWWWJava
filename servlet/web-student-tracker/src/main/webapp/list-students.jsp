<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Tracker App</title>
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
	<div id="wrapper">
		<div class="container-fluid">
			<div class="header">
				<h1>Danh sách sinh viên lớp ${CLASS.className}</h1>
			</div>
			<div class="control">
				<a type="button" class="btn btn-primary"
					href="StudentControllerServlet">Quay lại DS lớp học</a>
				<c:url var="addStudentPage" value="StudentControllerServlet">
					<c:param name="command" value="ADD_STUDENT_PAGE"></c:param>
					<c:param name="classId" value="${CLASS.classId}"></c:param>
				</c:url>
				<a class="btn btn-primary" href="${addStudentPage}">Thêm sinh
					viên mới </a>
			</div>
			<div class="show-data">
				<input type="hidden" name="classId" value="${CLASS.classId}">
				<table class="table table-striped table-hover">
					<thead class="bg-primary">
						<tr>
							<th>ID</th>
							<th>Họ</th>
							<th>Tên</th>
							<th>Giới tính</th>
							<th>Email</th>
							<th>Lớp</th>
							<th>Avatar</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempStudent" items="${STUDENT_LIST}">
							<c:url var="editLink" value="StudentControllerServlet">
								<c:param name="command" value="LOAD_STUDENT"></c:param>
								<c:param name="studentId" value="${tempStudent.id}"></c:param>
							</c:url>
							<c:url var="deleteLink" value="StudentControllerServlet">
								<c:param name="command" value="DELETE_STUDENT"></c:param>
								<c:param name="studentId" value="${tempStudent.id}"></c:param>
								<c:param name="classId" value="${tempStudent.classes.classId}"></c:param>
							</c:url>
							<tr>
								<td data-id="${tempStudent.id}">${tempStudent.id}</td>
								<td>${tempStudent.firstName}</td>
								<td>${tempStudent.lastName}</td>
								<td><c:if test="${not tempStudent.gender}">Nam</c:if> <c:if
										test="${tempStudent.gender}">Nữ</c:if></td>
								<td><a href="mailto:${tempStudent.email}">${tempStudent.email}</a>
								</td>
								<td>${tempStudent.classes.className}</td>
								<td><img class="rounded avatar"
									src="${tempStudent.imageUrl}" width="64" height="64" /></td>
								<td><a class="btn btn-primary" href="${editLink}">Edit</a>
									<a class="btn btn-danger" href="${deleteLink}"
									onclick="if (!confirm('Are you sure you want to delete this student?')) { return false; }">
										Delete </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/script.js"></script>
</body>

</html>