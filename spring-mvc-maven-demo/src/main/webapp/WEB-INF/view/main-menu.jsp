<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>JSP Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />
</head>

<body>
	<h1>Spring MVC Demo - Home page</h1>
	<a class="btn" href="hello/showForm">Plain Hello world</a>
	<br />
	<a class="btn" href="student/showForm">student form</a>
	<br />
	<a class="btn" href="student-valid/showForm"> student form
		validation </a>
</body>

</html>