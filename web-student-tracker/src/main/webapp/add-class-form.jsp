<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new class form</title>
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

.show-data thead {
	color: #fff;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div class="container-fluid">
			<div class="header">
				<h1>Add Class form</h1>
			</div>
			<div class="control">
				<a type="button" class="btn btn-primary"
					href="StudentControllerServlet">Quay lại DS lớp học</a>
			</div>
		</div>
	</div>
</body>
</html>