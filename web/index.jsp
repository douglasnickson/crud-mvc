<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 16/04/19
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Crud MVC - Página Inicial</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/css/crud-mvc.css">
  </head>
  <body>
  <div class="vertical-center bg-light">
    <div class="container">
      <h2>Acessar o Sistema</h2>
      <row>
        <div class="col-12">
          <form action="front-controller" method="POST">
            <div class="form-group">
              <label for="email">Email:</label><br/>
              <input type="email" id="email" name="email"><br/>
            </div>

            <div class="form-group">
              <label for="senha">Senha:</label><br/>
              <input type="password" id="senha" name="senha"><br/>
            </div>

            <input type="hidden" name="command" value="login">
            <button class=" btn btn-primary rounded" type="submit">Fazer Login</button>
          </form>
        </div>
      </row>

      <div class="row">
        <div class="col-12">
          <div>
            <a href="front-controller?command=cadastro">Não tem conta? Cadastre-se</a>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-12">
          <div class="container">
            <%--@elvariable id="error" type="java.lang.String"--%>
            <c:if test="${not empty error}">
              <div class="alert-danger">${error}</div>
            </c:if>
            <%--@elvariable id="success" type="java.lang.String"--%>
            <c:if test="${not empty success}">
              <div class="alert-success">${success}</div>
            </c:if>
          </div>
        </div>
        </div>
      </div>

    </div>

  <script src="./static/js/jquery-3.4.0.min.js"></script>
  <script src="./static/js/popper.min.js"></script>
  <script src="./static/plugins/bootstrap/js/bootstrap.js"></script>
  </body>
</html>
