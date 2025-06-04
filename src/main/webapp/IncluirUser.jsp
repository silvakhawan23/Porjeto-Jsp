<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f7f8;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background: white;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        width: 400px;
    }
    h2 {
        text-align: center;
        color: #004080;
        margin-bottom: 25px;
    }
    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #333;
    }
    input[type="text"], select {
        width: 100%;
        padding: 8px 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 14px;
    }
    input[type="submit"] {
        margin-top: 25px;
        width: 100%;
        background-color: #004080;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #003060;
    }
</style>
</head>
<body>
 <div class="container">
    <h2>Cadastro de Usuário</h2>
    <form action="incluirUser" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${usuario != null ? usuario.nome : ''}" />

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${usuario != null ? usuario.email : ''}" />

        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="${usuario != null ? usuario.cpf : ''}" />

        <label for="municipio_id">Município:</label>
        <select id="municipio_id" name="municipio_id">
            <c:forEach var="m" items="${municipios}">
                <option value="${m.id}"
                    <c:if test="${usuario != null && usuario.municipio != null && m.id == usuario.municipio.id}">
                        selected
                    </c:if>>
                    ${m.nome}
                </option>
            </c:forEach>
        </select>

        <input type="submit" value="Cadastrar" />
    </form>
</div>
</body>
</html>
