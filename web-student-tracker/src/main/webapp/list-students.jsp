<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	</link>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div class="container">
		<div class="content">
			<input type="button" value="Add Student"
			onclick="window.location.href='add-student-form.jsp'; return false;"
			class="add-student-button">
		</div>
	</div>
</body>

</html>