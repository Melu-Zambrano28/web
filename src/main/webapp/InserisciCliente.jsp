<!--<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/02/2018
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>   -->
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Benvenuto</title>
    <link rel="stylesheet" type="text/css" href="front-end/css/InserisciClienteStyle.css">
</head>

<body>
<!--
<form action="cliente" method="post">
    <div id="form">
        <br><label>Nome:</label><input type="text" placeholder="nome" required name="nome" class="zebra"><br>
        <br><label>Cognome:</label><input type="text" placeholder="cognome" required name="cognome" class="zebra"><br>
        <br><label>Data di nascita:</label><input type="date" required name="data-nascita" class="zebra"><br>
        <br><label><input type="submit" value="Registrati" class="button" id="valida"></label><br>
    </div>
</form>     -->
<form action="cliente" method="post">
    <div id="form">
        <br><label>Nome:</label><input type="text" placeholder="nome" name="nome" class="zebra" ><br>
        <br><label>Cognome:</label><input type="text" placeholder="cognome" name="cognome" class="zebra"><br>
        <br><label>Data di nascita:</label><input type="date" name="data-nascita" class="zebra"><br>
        <br><label><input type="submit" value="Registrati" class="button" id="valida"></label>
        <button type="reset" value="Reset" class="button">Reset</button>
    </div>
</form>
<script type="text/javascript" src="front-end/js/ConvalidaFormStadio.js"></script>
<%@ include file = "footer.jsp" %>
</html>
