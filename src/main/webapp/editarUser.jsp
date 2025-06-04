<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuário</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        background-color: white;
        padding: 25px 35px;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        width: 350px;
    }
    form h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #004080;
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
        font-weight: bold;
        border: none;
        padding: 10px 0;
        border-radius: 4px;
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

<form action="editarUser" method="post">
    <h2>Editar Usuário</h2>
    <input type="hidden" name="id" value="${usuario != null ? usuario.id : ''}" />

    <label>Nome:</label>
    <input type="text" name="nome" value="${usuario != null ? usuario.nome : ''}" />

    <label>Email:</label>
    <input type="text" name="email" value="${usuario != null ? usuario.email : ''}" />

    <label>CPF:</label>
    <input type="text" name="cpf" value="${usuario != null ? usuario.cpf : ''}" />

    <label>Município:</label>
    <select name="municipio_id">
        <c:forEach var="m" items="${municipios}">
            <option value="${m.id}" ${usuario != null && usuario.municipio != null && m.id == usuario.municipio.id ? 'selected="selected"' : ''}>
                ${m.nome}
            </option>
        </c:forEach>
    </select>

    <input type="submit" value="Salvar" />
</form>

</body>
</html>
