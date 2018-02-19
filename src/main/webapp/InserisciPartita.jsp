<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 14/02/2018
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserisci Partita</title>
    <link href="front-end/css/InserisciPartitaStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="partita">
    <div class="imaginesPartita">

        <p id="inserisciPartita">INSERISCI PARTITA</p>
        <a href="#registraPartita">
            <img src="front-end/img/partita.jpg">
        </a>
    </div>
</div>

    <div class="registraPartita">

        <table>
            <form  name="registraPartita" method="post" action="/gestionaleSportivo/inserisciPartita">
                <tr>
                    <td><label>Data partita: </label></td>
                    <td><input type="date" name="dataPartita" id =" dataPartita"/></td>

                </tr>
                <tr>
                    <td><label>Squadra Home: </label></td>
                    <td><input type="text" name="sqHome" id ="sqHome"/></td>

                </tr>
                <tr>
                    <td><label>Squadra Visitor: </label></td>
                    <td><input type="text" name="sqVisitor" id ="sqVisitor"/></td>

                </tr>

                <tr>
                    <td><label>Stadio: </label></td>
                    <td><input type="text" name="idStadio" id ="idStadio"/></td>

                </tr>
                <tr><!-- colonna -->
                    <td><input type="submit" name="inviaPartita" value="Invia"></td>
                    <td><input type="reset" name="cancellaPartita" value="Cancella"></td>
                </tr>
            </form>
        </table>

    </div>
</body>
</html>
