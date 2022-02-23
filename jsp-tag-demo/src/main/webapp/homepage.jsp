<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*,iuh.fit.src.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String[] cities = { "1. Mumbai", "2. Singapore", "3. Ho Chi Minh" };
pageContext.setAttribute("myCities", cities);
%>
</head> 
<body>
	<p>demo ForEach:</p>
	<c:forEach var="tempCity" items="${myCities}">
		${tempCity} <br/>
	</c:forEach>

	<p>demo If:</p>
	<%
	List<Student> data = new ArrayList<>();
	data.add(new Student("John", "Doe", true));
	data.add(new Student("Maxwell", "Johruenson", true));
	data.add(new Student("Mary", "public", false));
	pageContext.setAttribute("myStudents", data);
	%>
	<table border="1">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Gender</th>
		</tr>
		<c:forEach var="tempStudent" items="${myStudents}">
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td><c:if test="${tempStudent.gender}">Male</c:if> <c:if
						test="${not tempStudent.gender}">Female</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<p>demo function:</p>
	<c:set var="data" value="we love 2 core" />
	<p>
		Length of the string <b>${data}</b>: ${fn:length(data) }
	</p>
	<p>
		Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data) }
	</p>
	<p>
		Does the string <b>${data}</b> start with <b>luv</b>?:
		${fn:startsWith(data, "luv")}
	</p>
</body>
</html>