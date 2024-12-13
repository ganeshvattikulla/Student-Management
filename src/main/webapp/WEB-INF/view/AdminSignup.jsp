<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Signup</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container" style="width: 400px; margin-top: 100px;">
		<h2 class="text-center mt-5">Admin Signup</h2>


		<!-- Spring form for signup -->
		<form:form action="adminSignUp" method="post" modelAttribute="admin">
			<div class="form-group">
				<label for="adminName">Admin Name:</label>
				<form:input path="adminName" id="adminName" class="form-control"
					required="true" />
			</div>

			<div class="form-group">
				<label for="adminPassword">Password:</label>
				<form:password path="adminPassword" id="adminPassword"
					class="form-control" required="true" />
			</div>

			<div class="form-group">
				<label for="adminRole">Admin Role:</label>
				<form:select path="adminRole" class="form-control">
					<form:option value="Dept_Admin">Department Head</form:option>
					<form:option value="Super_Admin">Principal</form:option>
				</form:select>
			</div>

			<div class="form-group">
				<label for="deptName">Department Name:</label>
				<form:select path="deptName" class="form-control">
					<form:option value="NA">NA</form:option>
					<!-- For Super_Admin -->
					<form:option value="ECE">ECE</form:option>
					<form:option value="CSC">CSC</form:option>
					<form:option value="MECH">MECH</form:option>
					<form:option value="CIVIL">CIVIL</form:option>
					<form:option value="EEE">EEE</form:option>
				</form:select>
			</div>

			<button type="submit" class="btn btn-primary btn-block">Sign
				Up</button>
		</form:form>

		<p class="text-center mt-3">
			Already have an account? <a href="adminLoginPage">Login here</a>.
		</p>
	</div>

	<!-- Popup Notification -->
	<script type="text/javascript">
		// Check if the message attribute is present
		<c:if test="${not empty message}">
		// Display an alert with the message
		alert('${message}');
		</c:if>
	</script>
</body>
</html>
