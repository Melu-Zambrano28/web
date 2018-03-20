<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 19/03/2018
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="shortcut icon" href="front-end/img/login.png" type="image/ico" />
    <link href="front-end/css/LoginGestoreStyle.css" rel="stylesheet" type="text/css">

</head>
<body>
    <div class="areaLogin">
        <form action="loginGestore" method="get">

            Username: <input type="text" name="user">
            <br>
            Password: <input type="password" name="pwd">
            <br>
            <input id ="bottone" type="submit" value="Login" name="login">
        </form>

    </div>

</body>
</html>
