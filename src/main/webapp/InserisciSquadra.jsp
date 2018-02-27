<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 14/02/2018
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserisci Squadra</title>
    <link href="front-end/css/InserisciSquadraStyle.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="partita">
    <div class="imaginesPartita">

        <p id="inserisciSq">INSERISCI SQUADRA</p>
        <a href="#registraSquadra">
            <img src="front-end/img/squadra.jpg">
        </a>
    </div>
</div>

<div class="inserisciSquadra">

    <table>
        <form  name="formularioSquadra" method="post" action="inserisciSquadra">
            <tr>
                <td><label>Nome squadra: </label></td>
                <td><input type="text" name="nomeSquadra" id =" nomeSquadra"/></td>

            </tr>
            <tr><!-- colonna -->
                <td><input type="submit" name="inviaSquadra" value="Invia"></td>
                <td><input type="reset" name="cancellaSquadra" value="Cancella"></td>
            </tr>
        </form>
    </table>

</div>
</body>
</html>
