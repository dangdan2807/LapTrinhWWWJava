<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>student confirmation</title>
</head>

<body>
	The student is confirmation: ${student.firstName} ${student.lastName}
	<br /> Country: ${student.country}
	<br /> Phone: ${student.phone}
	<br /> Year of birth: ${ student.yearOfBirth}
	<br /> Postal Code: ${ student.postalCode}
<%-- 	<br /> Course Code: ${ student.courseCode} --%>
</body>

</html>