<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<style>
	table {
		border-collapse: collapse;
	}
	
	th, td {
		border: 1px solid black;
		padding: 5px;
	}
	
	.borderless{
		border: 0;
	}
}
</style>
</head>
<body>
	<h2>New employee</h2>
	<form action="employee" method="post">
		<br>
		<label>First name:</label>
		<input type="text" name="firstName">
		<br>
		<label>Last name:</label>
		<input type="text" name="lastName">
		<br>
		<label>Role:</label>
		<input type="text" name="role">
		
		<br>

		<button type="submit" name="save" value="save">Save</button>
	</form>

	<br>

	<form method="get">
		<label>Type a name to search: </label> <input type="text"
			name="busca" value="${busca}">
		<button type="submit">Search</button>
	</form>

	<br>

	<form method="post">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Role</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listFilter}" var="row">
					<tr>
						<td><input name="inputId${row.id}" value="${row.id}" class="borderless" readonly></td>
						<td><input name="inputFirstName${row.id}" value="${row.firstName}" class="borderless"></td>
						<td><input name="inputLastName${row.id}" value="${row.lastName}" class="borderless"></td>
						<td><input name="inputRole${row.id}" value="${row.role}" class="borderless"></td>
						<td><button type="submit" name="update" value="${row.id}">Update</button></td>
						<td><button type="submit" name="delete" value="${row.id}"
							onclick="return confirm('Tem certeza?')">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>