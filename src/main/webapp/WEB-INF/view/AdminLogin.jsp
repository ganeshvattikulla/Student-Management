<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container" style="width:500px;margin-top:100px;">
        <h2 class="text-center mt-5">Admin Login</h2>

        <!-- Display error message if login failed -->
        <c:if test="${not empty message}">
            <div class="alert alert-danger">${message}</div>
        </c:if>

        <!-- Spring form for login -->
        <form:form action="adminLogin" method="Get" modelAttribute="admin">
            <div class="form-group">
                <label for="adminName">Admin Name:</label>
                <form:input path="adminName" id="adminName" class="form-control" required="true"/>
            </div>

            <div class="form-group">
                <label for="adminPassword">Password:</label>
                <form:password path="adminPassword" id="adminPassword" class="form-control" required="true"/>
            </div>
            <div class="form-group">
				<label for="adminRole">Admin Role:</label>
				<form:select path="adminRole" class="form-control">
					<form:option value="Dept_Admin">Department Head</form:option>
					<form:option value="Super_Admin">Principal</form:option>
				</form:select>
			</div>

            <button type="submit" class="btn btn-primary btn-block">Login</button>
        </form:form>

        <p class="text-center mt-3">
            Don't have an account? <a href="adminSignupPage">Sign up here</a>.
        </p>
    </div>
</body>
</html>
