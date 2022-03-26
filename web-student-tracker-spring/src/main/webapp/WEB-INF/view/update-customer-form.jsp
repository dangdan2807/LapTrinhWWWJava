<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form Sửa Thông Tin Khách Hàng</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<div id="wrapper">
		<div class="container">
			<div class="header bg-primary pb-4 pt-4">
				<h1 class="text-white text-center">Form Sửa Thông Tin Khách
					Hàng</h1>
			</div>
			<div class="control mt-1 mb-1">
				<a class="btn btn-primary" href="./list-customers">Quay lại</a>
			</div>
			<div class="container">
				<div id="notify" class="alert alert-success d-none" role="alert"></div>
				<form:form action="./update-customer" modelAttribute="customer"
					method="POST">
					<div class="row">
						<div class="col-xl-7">
							<div class="form-group">
								<form:label path="id" cssClass="font-weight-bold">Customer Id:</form:label>
								<form:input path="id" cssClass="form-control" readonly="true" />
							</div>
							<div class="form-group">
								<form:label path="firstName" cssClass="font-weight-bold">Họ: </form:label>
								<form:input path="firstName" cssClass="form-control"
									placeholder="Nhập họ khách hàng ..." />
								<form:errors path="firstName" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<form:label path="lastName" cssClass="font-weight-bold">Tên: </form:label>
								<form:input path="lastName" cssClass="form-control"
									placeholder="Nhập tên khách hàng ..." />
								<form:errors path="lastName" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<form:label path="email" cssClass="font-weight-bold">Email: </form:label>
								<form:input path="email" cssClass="form-control"
									placeholder="Nhập email khách hàng ..." />
								<form:errors path="email" cssClass="text-danger" />
							</div>
							<button type="submit" class="btn btn-primary" value="Save">Save</button>
							<a type="button" class="btn btn-danger" href="./list-customers">Cancel</a>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		var url_string = window.location.href;
		var url = new URL(url_string);
		var param = url.searchParams.get("result");
		const messageElement = document.getElementById('notify');
		var className = 'alert-success';
		var message = 'Cập nhật';
		var type = 'thành công';

		if (param === 'add' || param === 'true' || param === 'false') {
			if (param === 'add') {
				message = 'Thêm';
			} else if (param === 'false') {
				className = 'alert-danger';
				type = 'thất bại';
			}

			messageElement.textContent = message + ' thông tin khách hàng '
					+ type;
			messageElement.classList.add(className);
			messageElement.classList.remove('d-none');
		}
	</script>
</body>

</html>