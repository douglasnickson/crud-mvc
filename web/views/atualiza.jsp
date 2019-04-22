<%--
  Created by IntelliJ IDEA.
  User: douglasnickson
  Date: 17/04/19
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud MVC - Atualização de Usuário</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/css/crud-mvc.css">
</head>
<body>
<div class="vertical-center bg-light">
    <div class="container">
        <h2>Atualizar Usuário</h2>
        <row>
            <div class="col-12">
                <form action="front-controller" method="POST">

                    <div class="form-group">
                        <label for="nome">Nome:</label><br/>
                        <input type="text" name="nome" id="nome" value="<%=session.getAttribute("nome")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label><br/>
                        <input type="email" name="email" id="email" value="<%=session.getAttribute("email")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="senha">Senha:</label><br/>
                        <input type="password" name="senha" id="senha" value="<%=session.getAttribute("senha")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="cpf">CPF:</label><br/>
                        <input type="text" id="cpf" name="cpf" value="<%=session.getAttribute("cpf")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="sexo">Sexo:</label><br/>
                        <input type="text" id="sexo" name="sexo" value="<%=session.getAttribute("sexo")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="idade">Idade:</label><br/>
                        <input type="number" id="idade" name="idade" value="<%=session.getAttribute("idade")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="isAdmin">IsAdmin:</label><br/>
                        <input type="text" id="isAdmin" name="isAdmin" value="<%=session.getAttribute("isAdmin")%>"><br/>
                    </div>

                    <div class="form-group">
                        <label for="funcao">Função:</label><br/>
                        <input type="text" id="funcao" name="funcao" value="<%=session.getAttribute("funcao")%>"><br/>
                    </div>

                    <input type="hidden" name="command" value="editar">
                    <input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
                    <button class=" btn btn-primary rounded" type="submit">Atualizar Usuário</button>
                </form>
            </div>
        </row>

        <div class="row">
            <div class="col-12">
                <div>
                    <a href="front-controller?command=principal">Retornar para lista de usuários</a>
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
