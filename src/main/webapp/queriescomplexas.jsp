<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Queries Complexas</title>
<style type="text/css">
	
	table {
		border-collapse:collapse;
	}
	
	th, td{
		border: 1px solid black;
		padding: 5px;
	}

</style>
</head>
<body>
	<h2>Queries complexas</h2>
	
	<h3>Task left join Employee</h3>
	<table>
		<thead>
			<tr>
				<th>Task ID</th>
				<th>Title</th>
				<th>Completed</th>
				<th>Employee name</th>
				<th>Employee role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listLeftJoin}" var="row">
				<tr>
					<td>${row.id}</td>
					<td>${row.title}</td>
					<td>${row.completed}</td>
					<td>${row.employee.firstName} ${row.employee.lastName}</td>
					<td>${row.employee.role}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h3>Employee starting with "y"</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listByLetter}" var="row">
				<tr>
					<td>${row.id}</td>
					<td>${row.firstName}</td>
					<td>${row.lastName}</td>
					<td>${row.role}</td>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>