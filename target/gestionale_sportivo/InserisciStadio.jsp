<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 09/02/2018
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserisci Stadio</title>
    <link href="front-end/css/GestoreStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="front-end/js/ConvalidaFormStadio.js"></script>
</head>
<body>
<h1>REGISTRO STADIO</h1>


<div class="stadio">

<div class="imaginestadio">

    <p id="inserisci">INSERISCI UN STADIO</p>
    <a href="#registraStadio">
        <img src="front-end/img/stadio.jpg">
    </a>
</div>

<div class="registraStadio">

    <table>
        <form  name="formul" method="post" action="inserisciStadio" id="formul">
            <tr>
                <td><label>Nome stadio: </label></td>
                <td><input type="text" name="nomeStadio" id ="nomeStadio"/></td>

            </tr>
            <tr>
                <td><label>Capienza: </label></td>
                <td><input type="text" name="capienza" id ="capienza"/></td>

            </tr>

            <tr>
                <td><label>Costo del biglieto: </label></td>
                <td><input type="text" name="prezzo" id ="prezzo"/></td>
            </tr>

            <tr><!-- colonna -->
                <td><input type="submit" name="invia" value="Invia" onclick="convalidaForm()"></td>
                <td><input type="reset" name="cancella" value="Cancella"></td>
            </tr>
        </form>

    </table>
</div>
</div>


</body>
</html>
