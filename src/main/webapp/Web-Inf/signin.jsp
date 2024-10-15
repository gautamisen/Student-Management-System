<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body class="bg-primary">
	<div class="d-flex justify-content-center align-item-center "
		style="margin-top: 200px">
		<div class="card bg-secondary"
			style="width: 48rem; height: 400px; justify-content: center;">
			<form:form action="/signin" method="post" modelAttribute="admin">
				<div class="card-body">
					<div class="d-flex justify-content-center align-item-center">
						<div
							class="text-warning mb-3 h5">${error}</div>
						<div class="text-success mb-3">${sucess}</div>
					</div>
					<div class="form-floating mb-3 ">
						<form:input path="email" type="email" class="form-control"
							id="emailInput" placeholder="" />
						<label for="emailInput">Username or email</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="password" type="password" class="form-control"
							id="passwordInput" placeholder="" />
						<label for="passwordInput">Password</label>
					</div>

					<div class="mt-5">
						<button class="btn btn-primary d-grid mx-auto" type="submit">Signin</button>
					</div>

				</div>
			</form:form>
		</div>
	</div>
</body>
</html>