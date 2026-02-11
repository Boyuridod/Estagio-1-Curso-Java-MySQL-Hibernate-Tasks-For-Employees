<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ToDo List</title>
</head>
<style>
table {
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 5px;
}

.borderless {
	border: 0;
}
</style>
<body>

	<h2>New task</h2>

	<form action="tasks" method="post">
		<label>Task name: </label> <input type="text" name="title"
			required /> <br> <input type="radio" id="completed"
			name="completed" value="completed" /> <label>Completed</label> <br>
		<select id="employee" name="employee">
			<option value="default" default>Select an employee</option>
			<c:forEach items="${employees}" var="employee">
				<option value="${employee.id}">[${employee.id}]
					(${employee.role}): ${employee.firstName}</option>
			</c:forEach>
		</select> <br>
		<button type="submit" name="save" value="save">Save</button>
	</form>

	<h2>Task List</h2>

	<p>
		Total tasks: [
		<c:out value="${tasks.size()}" />
		]
	</p>

	<form method="post">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Completed</th>
					<th>Title</th>
					<th>Employee</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="row">
					<tr>
						<td><input name="inputId${row.id}" value="${row.id}"
							class="borderless" readonly></td>
						<td><input name="inputCompleted${row.id}"
							value="${row.completed}" class="borderless"></td>
						<td><input name="inputTitle${row.id}" value="${row.title}"
							class="borderless"></td>
						<td>
							<select id="inputEmployee${row.id}" name="inputEmployee${row.id}">
								<option value="${row.employee.id}">[${row.employee.id}]
										(${row.employee.role}): ${row.employee.firstName}</option>
								<c:forEach items="${employees}" var="employee">
									<option value="${employee.id}">[${employee.id}]
										(${employee.role}): ${employee.firstName}</option>
								</c:forEach>
							</select>
						</td>
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