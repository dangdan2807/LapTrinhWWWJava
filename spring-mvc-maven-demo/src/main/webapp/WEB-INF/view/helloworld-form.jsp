<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	Form 1
	<br />
	<form action="processForm" method="post">
		<input type="text" placeholder="What's your name?"/>
		<input type="submit"/>
	</form>
	<br />
	
	Form 2:
	<br />
	<form action="processFormVersionTwo" method="post">
		<input type="text" name="studentName" placeholder="What's your name?"/>
		<input type="submit"/>
	</form>
	<br />

	Form 3:
	<br />
	<form action="processFormVersionThree" method="post">
		<input type="text" name="studentName" placeholder="What's your name?"/>
		<input type="submit"/>
	</form>
</body>
</html>