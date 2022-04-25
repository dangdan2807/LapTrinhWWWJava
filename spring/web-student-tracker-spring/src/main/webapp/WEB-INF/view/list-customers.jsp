<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Danh sách khách hàng</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous"
>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet"
>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
>
</head>

<body>
	<div id="wrapper">
		<div class="container">
			<div class="header bg-primary pb-4 pt-4">
				<h1 class="text-white text-center">Danh Sách Khách Hàng</h1>
			</div>
			<div class="control mt-1 mb-1">
				<a class="btn btn-primary" href="./add-customer-form">Thêm khách hàng
					mới</a>
			</div>
			<div class="show-data">
				<input type="text" id="customerId" name="id" value="" hidden />
				<table class="table table-striped table-hover">
					<thead class="bg-primary">
						<tr>
							<th class="text-white">ID</th>
							<th class="text-white">Họ</th>
							<th class="text-white">Tên</th>
							<th class="text-white">Email</th>
							<th class="text-white">Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempCustomer" items="${customers}">
							<c:url var="editLink" value="./edit-customer-form">
								<c:param name="id" value="${tempCustomer.id}" />
							</c:url>
							<c:url var="deleteLink" value="./delete-customer">
								<c:param name="id" value="${tempCustomer.id}" />
							</c:url>
							<tr>
								<td data-id="${tempCustomer.id}">${tempCustomer.id}</td>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td><a href="mailto:${tempCustomer.email}">${tempCustomer.email}</a>
								</td>
								<td>
									<a class="btn btn-primary" href="${editLink}"
										onclick="document.getElementById('customerId').value='${tempCustomer.id}';"
									> 
										Edit 
									</a> 
									<a class="btn btn-danger" href="${deleteLink}"
										onclick="if (!confirm('Are you sure you want to delete this student?')) { return false; }"
									> 
									Delete 
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>