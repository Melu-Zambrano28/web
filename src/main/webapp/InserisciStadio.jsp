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
    <link href="front-end/css/InserisciStadioStyle.css" rel="stylesheet" type="text/css">
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
                <td><input type="text" name="nomeStadio" id =" nomeStadio"/></td>

            </tr>
            <tr>
                <td><label>Capienza: </label></td>
                <td><input type="text" name="capienza" id ="capienza"/></td>

            </tr>

            <tr>
                <td><label>Costo del biglieto: </label></td>
                <td><input type="text" name="prezzo" id =" prezzo"/></td>
            </tr>

            <tr><!-- colonna -->
                <td><input type="submit" name="invia" value="Invia" ></td>
                <td><input type="reset" name="cancella" value="Cancella"></td>
            </tr>
        </form>

    </table>
</div>
</div>

<div class="squadra">

<div class="imaginesquadra">

    <p id="inserisciSquadra">INSERISCI SQUADRA</p>
    <a href="#registraSquadra">
        <img src="front-end/img/squadra.jpg">
    </a>
</div>


<div class="inserisciSquadra">

    <table>
        <form  name="formularioSquadra" method="post" action="/gestionaleSportivo/inserisciSquadra">
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
</div>


<div class="partita">
<div class="imaginesPartita">

    <p id="inserisciPartita">INSERISCI PARTITA</p>
    <a href="#registraPartita">
        <img src="front-end/img/partita.jpg">
    </a>
</div>

<div class="registraPartita">

    <table>
        <form  name="registraPartita" method="post" action="">
            <tr>
            <td><label>Data partita: </label></td>
            <td><input type="text" name="dataPartita" id =" dataPartita"/></td>

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
</div>
</body>
</html>
