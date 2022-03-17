<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Cadastro Cliente</title>
</head>
<body>
<div class="container">
    <div class="card mt-5">
    <div class="card-header">
        <h1 class="text-center">Cadastro Cliente</h1>
    </div>
    <div class="card-body">
        <blockquote class="blockquote mb-0">

            <form:form id="frmCliente" action="" method="post" modelAttribute="formCliente">
                <div class="form-group text-center">
                    <form:label  path="nome_cliente">Nome</form:label>
                    <form:input  class="form-control" path="nome_cliente" placeholder="Digite o seu Nome"/>
                </div>
                <div class="form-group text-center">
                    <form:label path="cpf_cliente">CPF</form:label>
                    <form:input  class="form-control" path="cpf_cliente" placeholder="Digite o seu CPF" />
                </div>

                <div class="form-group text-center">
                    <form:label path="telefone_cliente">Telefone</form:label>
                    <form:input type="text" class="form-control" path="telefone_cliente" placeholder="Digite o seu Telefone"/>
                </div>
                <div class="text-center">
                    <form:button type="submit" class="btn btn-primary">Cadastrar</form:button>
                </div>

            </form:form>
        </blockquote>
    </div>
</div>
</div>


</body>
</html>