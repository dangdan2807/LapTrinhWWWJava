<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>student confirmation</title>
</head>

<body>
	customer list:
	<br />
	<ul>
		<c:forEach items="${customerList}" var="customer">
			<li>${customer.firstName}</li>
		</c:forEach>

	</ul>
	<c:url var="backToForm" value="./showForm">
	</c:url>
	<a href="${backToForm }">Quay lại form</a>
</body>

</html>