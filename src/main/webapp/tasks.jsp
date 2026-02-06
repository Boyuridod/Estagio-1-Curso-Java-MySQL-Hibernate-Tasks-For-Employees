<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>

<h2>Nova Tarefa</h2>

<form action="tasks" method="post">
	<label>Nome da tarefa: </label>
    <input type="text" name="title" required />
    <br>
    <input type="radio" id="completed" name="completed" value="completed" />
    <label>Completa</label>
    <br>
    <select id="employee" name="employee">
    	<option value="default" default>Selecione uma opção</option>
    	<c:forEach items="${employees}" var="employee">
			<option value="${employee.id}">[${employee.id}]
					(${employee.role}): ${employee.firstName}</option>
		</c:forEach>
    </select>
    <br>
    <button type="submit">Salvar</button>
</form>

<h2>Lista de Tarefas</h2>

<p> Quantidade de tasks [<c:out value="${tasks.size()}"/>]</p>

<ul>
   <c:forEach items="${tasks}" var="task">
        <li>${task.id} [Completed = ${task.completed}] ${task.title} funcionário: ${task.employee.firstName} ${task.employee.lastName}</li>
    </c:forEach> 
</ul>

</body>
</html>