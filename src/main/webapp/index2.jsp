<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Minhas Tarefas</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: linear-gradient(120deg, #4e73df, #1cc88a);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background: #fff;
            width: 100%;
            max-width: 900px;
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 20px 40px rgba(0,0,0,0.2);
            display: grid;
            grid-template-columns: 1fr 1fr;
        }

        .left {
            background-image: url("https://images.unsplash.com/photo-1487014679447-9f8336841d58");
            background-size: cover;
            background-position: center;
            padding: 40px;
            color: #fff;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .left h1 {
            font-size: 36px;
            margin-bottom: 10px;
        }

        .left p {
            font-size: 16px;
            line-height: 1.5;
        }

        .right {
            padding: 40px;
            display: flex;
            flex-direction: column;
        }

        form {
            display: flex;
            gap: 10px;
            margin-bottom: 25px;
        }

        input[type="text"] {
            flex: 1;
            padding: 14px;
            border-radius: 10px;
            border: 1px solid #ddd;
            font-size: 15px;
        }

        button {
            padding: 14px 22px;
            background: #4e73df;
            color: #fff;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-weight: bold;
            transition: 0.3s;
        }

        button:hover {
            background: #2e59d9;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
            overflow-y: auto;
            max-height: 360px;
        }

        li {
            background: #f8f9fc;
            margin-bottom: 10px;
            padding: 14px;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            border-left: 5px solid #4e73df;
        }

        .empty {
            text-align: center;
            color: #888;
            margin-top: 80px;
        }

        @media (max-width: 768px) {
            .container {
                grid-template-columns: 1fr;
            }

            .left {
                display: none;
            }
        }
    </style>
</head>

<body>

<div class="container">

    <!-- LADO ESQUERDO COM IMAGEM -->
    <div class="left">
        <h1>Gerenciador de Tarefas</h1>
        <p>
            Organize suas atividades, aumente sua produtividade e não perca prazos.
            Um projeto em Java + Servlet + Hibernate puro.
        </p>
    </div>

    <!-- LADO DIREITO COM TAREFAS -->
    <div class="right">

        <h2>Nova Tarefa</h2>

        <form action="tasks" method="post">
            <input type="text" name="title" placeholder="Digite sua tarefa..." required>
            <button type="submit">Adicionar</button>
        </form>

        <h2>Minhas Tarefas</h2>

        <ul>
            <c:forEach items="${tasks}" var="task">
                <li>
                    <span>${task.title}</span>
                </li>
            </c:forEach>

            <c:if test="${empty tasks}">
                <div class="empty">
                    Nenhuma tarefa cadastrada ainda 🚀
                </div>
            </c:if>
        </ul>

    </div>

</div>

</body>
</html>
