<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row g-3 align-items-center">
			<div class="col-auto mt-5">
				<form:form
					action="${pageContext.request.contextPath }/authenticateTheUser"
					mothed="POST">
					<div class="mb-4">
						<c:if test="${param.error != null }">
							<i class="alert alert-danger col-xs-offset-1 col-xs-10"
								role="alert">Sorry! You entered invalid username/password.</i>
						</c:if>
						<c:if test="${param.logout != null }">
							<i class="alert alert-success col-xs-offset-1 col-xs-10"
								role="alert">Sorry! You have been logged out</i>
						</c:if>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">
							<ion-icon name="person"></ion-icon>
						</span> 
						<input type="text" class="form-control" id="username" name="username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon2">
							<ion-icon name="lock-closed"></ion-icon>
						</span>
						<input type="password" class="form-control" id="password" name="password" aria-describedby="basic-addon2">
					</div>
					<input class="btn btn-success" type="submit" value="Login" />
				</form:form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>