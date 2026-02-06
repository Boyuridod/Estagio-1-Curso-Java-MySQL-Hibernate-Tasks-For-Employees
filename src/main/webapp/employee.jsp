<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<style>
.hidden {
	display: none;
}
</style>
</head>
<body>
	<h2>${active ? "Editar funcionário" : "Novo funcionário"}</h2>
	<form action="employee" method="post">
		<%-- <c:if test="${active}">
	        <label>
	            Id:
	            <input type="number" name="id"
	                   value="${employee.id}" readonly>
	        </label>
	        <br>
	    </c:if> --%>
		<label> Id: <input type="number" name="id"
			value="${employee.id}">
		</label> <br> <label>First name:</label> <input type="text"
			name="firstName"> <br> <label>Last
			name:</label> <input type="text" name="lastName"> <br>
		<label>Role:</label> <input type="text" name="role"> <br>
		<%-- 		<c:if test="${!active}">
        <button type="submit" name="action" value="save">Salvar</button>
 	    </c:if>
	
 	    <c:if test="${active}">
	        <button type="submit" name="action" value="update">Atualizar</button>
 	        <button type="submit" name="action" value="delete"
	                onclick="return confirm('Tem certeza?')">
	            Deletar
 	        </button>
 	    </c:if> --%>

		<button type="submit" name="action" value="save">Salvar</button>
		<button type="submit" name="action" value="update">Atualizar</button>
		<button type="submit" name="action" value="delete"
			onclick="return confirm('Tem certeza?')">Deletar</button>
	</form>

	<ul>
		<c:forEach items="${employees}" var="employee">
			<li><button value="${employee.id}">[${employee.id}]
					(${employee.role}): ${employee.firstName} ${employee.lastName}</button></li>
		</c:forEach>
	</ul>
</body>
</html>