<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 16/04/19
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Crud MVC - Cadastro de Usuário</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/css/crud-mvc.css">
</head>
<body>
<div class="vertical-center bg-light">
    <div class="container">
        <h2>Cadastrar Usuário</h2>
        <row>
            <div class="col-12">
                <form action="front-controller" method="POST">

                    <div class="form-group">
                        <label for="nome">Nome:</label><br/>
                        <input type="text" id="nome" name="nome"><br/>
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label><br/>
                        <input type="email" id="email" name="email"><br/>
                    </div>

                    <div class="form-group">
                        <label for="senha">Senha:</label><br/>
                        <input type="password" id="senha" name="senha"><br/>
                    </div>

                    <div class="form-group">
                        <label for="cpf">CPF:</label><br/>
                        <input type="text" id="cpf" name="cpf"><br/>
                    </div>

                    <div class="form-group">
                        <label for="sexo">Sexo:</label><br/>
                        <input type="text" id="sexo" name="sexo"><br/>
                    </div>

                    <div class="form-group">
                        <label for="idade">Idade:</label><br/>
                        <input type="number" id="idade" name="idade"><br/>
                    </div>

                    <div class="form-group">
                        <label for="isAdmin">IsAdmin:</label><br/>
                        <input type="text" id="isAdmin" name="isAdmin"><br/>
                    </div>

                    <div class="form-group">
                        <label for="funcao">Função:</label><br/>
                        <input type="text" id="funcao" name="funcao"><br/>
                    </div>

                    <input type="hidden" name="command" value="cadastrar">
                    <button class=" btn btn-primary rounded" type="submit">Cadastrar Usuário</button>
                </form>
            </div>
        </row>

        <div class="row">
            <div class="col-12">
                <div>
                    <a href="/crud-mvc">Retornar para Página Inicial</a>
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