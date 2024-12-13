<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<link href="/Student_Management/urlToReachCSS/css/studentListshow.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>
<body>
	<h3 align="center">Welcome Mr.${adminName}</h3>

	<header>
		<h2 id="header1">Student's Data</h2>
	</header>
	<div class="container">
		<div class="searchAdd">


			<div class="search border border-success">
				<div class="fa fa-search"></div>
				<input id="search" type="text" placeholder="Search" onkeyup="filterTable()">
			</div>

			<div>
				<form action="showAddStudentPage" method="GET">
    <input type="hidden" name="adminDeptName" value="${adminDeptName}" />
    <input type="submit" value="Add Student" class="btn btn-outline-success">
</form>

			</div>
		</div>

		<table id="studentTable"border="1" class="table table-striped table-hover">
			<thead >
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>MOBILE</th>
					<th>COUNTRY</th>
					<th>Department</th>

				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td>${student.deptName}</td>
					<td><a
						href="updateStudent?userID=${student.id}&adminDeptName=${adminDeptName}"class="btn btn-warning btn-sm">Update</a>
					</td>
					<td><a
						href="deleteStudent?userID=${student.id}&adminDeptName=${adminDeptName}"
						onclick="return confirm('Are you sure you want to delete?')"class="btn btn-danger btn-sm">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		// Function to filter the table based on search input
		function filterTable() {
			let input = document.getElementById('search');
			let filter = input.value.toLowerCase();
			let table = document.getElementById('studentTable');
			let rows = table.getElementsByTagName('tr');

			// Loop through all table rows and hide those that don't match the search query
			for (let i = 1; i < rows.length; i++) {  // Start from 1 to skip the table header
				let cols = rows[i].getElementsByTagName('td');
				let matchFound = false;

				// Loop through columns to check if any column contains the search value
				for (let j = 0; j < cols.length - 1; j++) {  // Ignore the action buttons column
					if (cols[j]) {
						let textValue = cols[j].textContent || cols[j].innerText;
						if (textValue.toLowerCase().indexOf(filter) > -1) {
							matchFound = true;
							break;
						}
					}
				}

				// Show or hide the row based on the match result
				if (matchFound) {
					rows[i].style.display = '';
				} else {
					rows[i].style.display = 'none';
				}
			}
		}

	</script>
	<footer style="margin-top:50px;">Copyrights @Ganesh 2024.</footer>
</body>
</html>
