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
    <div class="areaLogin" id="login">
        <form action="loginGestore" method="get">

            Username: <input type="text" name="user" id="nickname">
            <br>
            Password: <input type="password" name="pwd">
            <br>
            Dominio:
            <select name="ruolo">
                <option value="amministratore">@Amministratore.it</option>
                <option value="clliente">@Cliente.it</option>

            </select>
            <br>

           <input id ="bottone" type="submit" value="Login" name="login">
        </form>

        <div id="modifica" style="float: bottom;">
            <input type="submit" value="modifica Password" name="modifica" onclick="mostramiFormModificaPassword(),nascondiLogin(), dammiNome()">
        </div>

    </div>

<div id="modificaPassword">
    <form>

        Username: <input type="text" name="userM" id="nomeModificato">
        <br>
        Password: <input type="passwordModificata" name="pwdM">
        <br>

        <input type="submit" value="Invia" name="modificaPwd">
    </form>

</div>
</body>
<script>
    document.getElementById("modificaPassword").style.display="none";

    function mostramiFormModificaPassword() {
        document.getElementById("modificaPassword").style.display="block";
    }

    function nascondiLogin() {
        document.getElementById("login").style.display='none';
    }

    function prendiNome() {
        var nome= document.getElementById("nickname").value;
        return nome;
    }
    function dammiNome() {
        document.getElementById("nomeModificato").value =prendiNome(); //innerhtml non serve in questo caso, perchè l'elemtno appartiene al form

    }

</script>
</html>
