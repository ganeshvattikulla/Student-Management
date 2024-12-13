<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddStudentPage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body align="center">
	<h2 style="text-align:center; margin-top:50px;" >Enter Student Details😀</h2>
	<br>

	<div class="container" style="width: 500px;">
		<form:form action="save-student" method="POST"
			modelAttribute="student">
			<!-- Regular hidden field for adminDeptName -->
			<input type="hidden" name="adminDeptName" value="${adminDeptName}" />

			<form:hidden path="id" />
		
		Name<form:input path="name" class="form-control mb-2" />
			<br>
		
		Mobile<form:input path="mobile" class="form-control mb-2" />
			<br>
		
		Country<form:input path="country" class="form-control mb-2" />
			<br>
		
		Department 
		<form:select path="deptName" class="form-control mb-2">
				<form:option value="ECE">ECE</form:option>
				<form:option value="CSC">CSC</form:option>
				<form:option value="MECH">MECH</form:option>
				<form:option value="CIVIL">CIVIL</form:option>
				<form:option value="EEE">EEE</form:option>
			</form:select>
			<br>

			<input type="submit" value="Submit" class="btn btn-primary mb-2">
		</form:form>
	</div>

</body>
</html>