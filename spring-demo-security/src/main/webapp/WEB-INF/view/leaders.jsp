<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leaders page</title>
</head>
<body>
	<h1>leaders page</h1>
	<form:form action="${pageContext.request.contextPath}/logout" method ="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	<c:if test="${param.logout != null }">
		<div class="alert alert-success col-xs-offset-1 col-xs10">You
			have been logged out.</div>
	</c:if>
</body>
</html>