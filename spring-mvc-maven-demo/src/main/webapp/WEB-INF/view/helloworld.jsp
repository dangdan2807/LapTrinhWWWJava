<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
	Hello World of Spring
	<br/>
	Student name: ${param.studentName}
	<br />
	<% 
		Object message = request.getAttribute("message");
		out.println(message != null ? "the message: " + message.toString() : ""); %>
</body>
</html>