<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Page</title>
</head>
<body>
	<h2>SE Company Home Page</h2>
	<hr />
	Welcome to the SE company home page yoyo!
	<p>
		User:
		<security:authentication property="principal.username" />
		Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admin peeps)
		</p>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	<c:if test="${param.logout != null }">
		<div class="alert alert-success col-xs-offset-1 col-xs10">You
			have been logged out.</div>
	</c:if>
</body>
</html>