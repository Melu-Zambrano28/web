<%@ page import="it.fides.sportivo.entity.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/02/2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% Cliente clio = (Cliente) request.getAttribute("cliente"); %>
<html>
<head>
    <title>Benvenuto <%= clio.getNome()  %> </title>
    <link rel="stylesheet" type="text/css" href="front-end/css/InserisciClienteStyle.css">
</head>
<body>
<h1 id="benvenuto"> Benvenuto <%= clio.getNome() %></h1>


<form action="InserisciCliente.jsp">
    <input type="submit" value="Go to Home" />
</form>

</body>
</html>
