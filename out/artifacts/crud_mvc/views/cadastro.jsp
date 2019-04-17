<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 16/04/19
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cadastrar Usuário</h1>
<form action="cadastro-usuario" method="POST">

    <label for="nome">Nome:</label><br/>
    <input type="text" name="nome" id="nome"><br/>

    <label for="email">Email:</label><br/>
    <input type="email" name="email" id="email"><br/>

    <label for="senha">Senha:</label><br/>
    <input type="password" name="senha" id="senha"><br/>

    <input type="hidden" name="flag" value="cadastrar">
    <button type="submit">Login</button>

</form>
</body>
</html>
