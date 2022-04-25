<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Hello World</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />
</head>

<body>
	Form 1
	<br />
	<form action="processForm" method="post">
		<input type="text" placeholder="What's your name?" />
		<input class="btn" type="submit" />
	</form>
	<br />

	Form 2:
	<br />
	<form action="processFormVersionTwo" method="post">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input class="btn" type="submit" />
	</form>
	<br />

	Form 3:
	<br />
	<form action="processFormVersionThree" method="post">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input class="btn" type="submit" />
	</form>
</body>

</html>