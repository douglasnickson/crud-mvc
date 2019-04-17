<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 16/04/19
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      label {width: 80px; float: left;}
    </style>
  </head>
  <body>
  <h1>Acessar o Sistema de Cadastro</h1>
  <form action="cadastro-usuario" method="POST">

    <label for="email">Email:</label><br/>
    <input type="email" id="email"><br/>

    <label for="senha">Senha:</label><br/>
    <input type="password" id="senha"><br/>

    <input type="hidden" name="flag" value="login">
    <button type="submit">Login</button>

    <div>
      <a href="cadastro-usuario?flag=cadastro">Não tem conta? Cadastre-se</a>
    </div>
  </form>
  <h3>Teste</h3>
  </body>
</html>
