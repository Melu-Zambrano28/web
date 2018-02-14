<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/02/2018
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Benvenuto</title>
    <link rel="stylesheet" type="text/css" href="frontend/css/Cliente.css">
</head>
<body>
<form action="cliente" method="post">
    <div id="form">
        <label>Nome:</label><input type="text" placeholder="nome" required name="nome"><br>
        <label>Cognome:</label><input type="text" placeholder="cognome" required name="cognome"><br>
        <label>Data di nascita:</label><input type="date" required name="data-nascita"><br>
        <label><input type="submit" value="Registrati" class="button"></label><br>
    </div>
</form>
</body>
</html>
