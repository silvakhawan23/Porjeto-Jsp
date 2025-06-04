<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="CrudBom.model.Usuario" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista de Usuários</title>
    <style>
    .botao-voltar {
    position: absolute;
    top: 10px;
    left: 10px;
    background-color: #004080;
    color: white;
    padding: 10px 15px;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
}
.botao-voltar:hover {
    background-color: #0066cc;
}
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            color: #004080;
            margin-bottom: 20px;
        }

        table {
            width: 90%;
            max-width: 1000px;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #004080;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #004080;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
            color: #0077cc;
        }
    </style>
</head>
<body>
<a href="index.jsp" class="botao-voltar">Voltar</a>

<h2>Usuários cadastrados</h2>

<table>
    <tr>
        <th>Editar</th>
        <th>Excluir</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>CPF</th>
        <th>Município</th>
    </tr>
    <%
    	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("Usuario");
        if (usuarios != null) {
            for (Usuario u : usuarios) {
    %>
    <tr>
        <td><a href="editarUser?id=<%= u.getId() %>">Editar</a></td>
        <td><a href="excluirUser?id=<%= u.getId() %>">Excluir</a></td>
        <td><%= u.getId() %></td>
        <td><%= u.getNome() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getCpf() %></td>
        <td><%= (u.getMunicipio() != null) ? u.getMunicipio().getNome() : "N/A" %></td>
    </tr>
    <% 
            }
        } 
    %>
</table>



</body>
</html>
