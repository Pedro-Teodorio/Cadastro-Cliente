<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Terminei Porra vc � foda <%=request.getAttribute("id")%></h1>
<h1>Terminei Porra vc � foda <%=request.getAttribute("nome")%></h1>
<%
    String redirectURL = "/listaCliente";
    response.sendRedirect(redirectURL);
%>
</body>
</html>