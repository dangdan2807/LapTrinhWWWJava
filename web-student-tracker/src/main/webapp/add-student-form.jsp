<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<meta charset="ISO-8859-1">
	<title>Add student form</title>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
		integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
		crossorigin="anonymous">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
	<style type="text/css">
		body {
			font-family: 'Roboto', sans-serif;
		}

		.header {
			background-color: #007bff;
			padding: 1rem 0px;
		}

		.header>h1 {
			text-align: center;
			font-weight: bold;
			color: #fff;
		}
		
		.control {
			margin: 4px 0;
		}
		
		form a.btn ~ #img-avatar {
			margin-bottom: 8px;
		}
	</style>
</head>

<body>
	<div class="container-fluid">
		<div class="header">
			<h1>Add Student Form</h1>
		</div>
		<div class="control">
			<a type="button" class="btn btn-primary"
				href="StudentControllerServlet">Back to Dashboard</a>
		</div>
		<form id="form" action="StudentControllerServlet" method="POST">
			<input type="hidden" name="command" value="ADD">
			<div class="form-group">
				<label for="firstName">First name</label> <input type="text"
					name="firstName" class="form-control" id="firstName"
					placeholder="Enter your first Name">
			</div>
			<div class="form-group">
				<label for="lastName">Last name</label> <input type="text"
					name="lastName" class="form-control" id="lastName"
					placeholder="Enter your last Name">
			</div>
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					name="email" class="form-control" id="email"
					placeholder="Enter your email address">
			</div>
			<div class="form-group">
				<label for="imageUrl">Avatar url image</label> <input type="text"
					name="imageUrl" class="form-control" id="imageUrl"
					placeholder="Enter your avatar url" onchange="imageUrlChanged();" />
			</div>
			<button type="submit" class="btn btn-primary" value="Save">Add student</button>
			<a type="button" class="btn btn-danger"
				href="StudentControllerServlet">Cancel</a> 
			<img id="img-avatar"
				class="float-right rounded img-avatar" src="" alt="image avatar" width="100"
				height="100" hidden>
		</form>
	</div>
	<script src="./js/script.js"></script>
</body>

</html>