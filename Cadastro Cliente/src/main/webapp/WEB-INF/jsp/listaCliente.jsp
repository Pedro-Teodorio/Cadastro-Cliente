<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Lista de Clientes</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h1 class="text-center">Lista de Clientes</h1>
        </div>
        <div class="card-body">
            <c:if test="${listaReq == null}">
                <p>Erro:Não foi possível executar a operação!</p>
            </c:if>

            <c:if test="${listaReq != null}">
            <table class="table">
                <thead>
                <tr>
                    <th class="text-center" scope="col">ID</th>
                    <th class="text-center" scope="col">Nome</th>
                    <th class="text-center" scope="col">CPF</th>
                    <th class="text-center" scope="col">Telefone</th>
                    <th class="text-center" colspan="2" scope="col">Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cliente" items="${listaReq}">
                    <tr>
                        <th class="text-center" scope="row">${cliente.id}</th>
                        <td class="text-center">${cliente.nome_cliente}</td>
                        <td class="text-center">${cliente.cpf_cliente}</td>
                        <td class="text-center">${cliente.telefone_cliente}</td>

                        <td class="text-center">
                            <button class="btn btn-primary" onclick="window.location.href='/alteraCliente/${cliente.id}'">Alterar</button>
                            <button class="btn btn-primary" onclick="window.location.href='/excluirCliente/${cliente.id}'">Excluir</button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
                </c:if>
            </table>


        </div>
        <button class="btn btn-primary text-center" onclick="window.location.href='/cadastroCliente'">Adicionar Cliente</button>
    </div>

</div>


</body>
</html>