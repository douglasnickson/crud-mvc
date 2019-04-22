<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 19/04/19
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Crud MVC - Página Principal</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/css/crud-mvc.css">
</head>
<body>

<div class="vertical-center bg-light">
    <div class="container">
        <h2>Olá, <%=session.getAttribute("nomeAutenticado")%></h2>
        <row>
            <div class="col-12">
                <h4 style="float: left">Lista de Usuários</h4>
                <a href="front-controller?command=cadastro"><button class="btn rounded btn-primary" style="float: right; margin-bottom: 5px;">Adicionar Usuário</button></a>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Cpf</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Idade</th>
                        <th scope="col">isAdmin</th>
                        <th scope="col">Funcao</th>
                        <th scope="col">Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${usuarios}">
                        <tr>
                            <th scope="row"><c:out value="${i.id}"/></th>
                            <td><c:out value="${i.nome}"/></td>
                            <td><c:out value="${i.email}"/></td>
                            <td><c:out value="${i.cpf}"/></td>
                            <td><c:out value="${i.sexo}"/></td>
                            <td><c:out value="${i.idade}"/></td>
                            <td><c:out value="${i.isAdmin}"/></td>
                            <td><c:out value="${i.funcao}"/></td>
                            <td><a href="front-controller?command=altera&id=${i.id}">Editar</a> | <a href="front-controller?command=excluir&id=${i.id}">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </row>

        <div class="row">
            <div class="col-12">
                <div>
                    <a href="front-controller?command=logout">Sair do Sistema</a>
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
