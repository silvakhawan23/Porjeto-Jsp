<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Menu CRUD</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        nav {
            background-color: #004080;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 20px;
            font-size: 18px;
            font-weight: bold;
            transition: 0.3s;
        }

        nav a:hover {
            text-decoration: underline;
            color: #ffd700;
        }

        h1 {
            margin-top: 30px;
            color: #004080;
        }
    </style>
</head>
<body>
    <nav>
        <a href="listarMunicipios">Cadastrar Usuário</a>
        <a href="ListarUser">Gestão de usuarios</a>
     
    </nav>

    <h1>Bem-vindo ao sistema de gerenciamento de usuários!</h1>
</body>
</html>
