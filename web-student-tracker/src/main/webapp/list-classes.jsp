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

.card-text__label {
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div class="container-fluid">
			<div class="header">
				<h1>Danh sách lớp học</h1>
			</div>
			<div class="control">
				<button class="btn btn-primary"
					onclick="window.location.href='add-class-form.jsp'; return false;">
					Thêm lớp học mới</button>
			</div>
			<div class="show-list-classes row">
				<c:forEach var="tempClass" items="${CLASS_LIST}">
					<c:url var="getStudentList" value="StudentControllerServlet">
						<c:param name="command" value="LOAD_LIST_STUDENT"></c:param>
						<c:param name="classId" value="${tempClass.classId}"></c:param>
					</c:url>
					<div class="col-6 col-sm-6 col-md-4 col-lg-4 col-xl-3 mb-2">
						<div class="card card-class">
							<div class="card-body">
								<h5 class="card-title">${tempClass.className}</h5>
								<p class="card-text">
									<span class="card-text__label">Khoa:</span>
									${tempClass.department.departmentName}
								</p>
								<a href="${getStudentList}" class="btn btn-primary">Danh
									sách sinh viên</a>
								<a href="${getStudentList}" class="btn btn-success">Sửa</a>
								<a href="${getStudentList}" class="btn btn-danger">Xóa</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>