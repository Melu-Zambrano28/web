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
    <link href="front-end/css/InserisciPartitaStyle.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
    <script type="text/javascript" src="front-end/js/ConvalidaFormStadio.js"></script>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario")== null){
        response.sendRedirect("LoginGestore.jsp");
    }
%>
<h1 id="registroStadio">REGISTRO STADIO</h1>


<div class="stadio">

<div class="imaginestadio">

    <a href="#registraStadio">
        <img src="front-end/img/stadio.jpg">
    </a>
</div>

<div id="registraStadio">

    <h1 style="color: white; text-align: left; text-shadow: 3px 2px cadetblue ;">INSERISCI UN STADIO</h1>

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
                <td><input type="button" name="modifica" value="Modifica stadio" onclick="mostraModifica(), nascondeInsertStadio()"></td>

            </tr>
        </form>


    </table>
</div>
</div>
</div>

<div id="modifica">
    <h1 style="text-align: left; color: white; text-shadow: 3px 2px cadetblue ;">Modifica dello stadio </h1>
    <table>
        <form  name="formularioModifica" method="post" action="modificaStadio">
            <tr>
                <td><label>Nome stadio: </label></td>
                <td><input type="text" name="nomeStadioModifica" /></td>

            </tr>
            <tr>
                <td><label>Capienza: </label></td>
                <td><input type="text" name="capienzaModifica"/></td>

            </tr>


            <tr><!-- colonna -->
                <td><input type="submit" name="modificaStadio" value="Modifica"></td>
                <td><input type="reset" name="cancella" value="Cancella"></td>
            </tr>
        </form>

    </table>

</div>

<script>
    var divInsertStadio = document.getElementById("registraStadio");
    var modificaStadio=document.getElementById("modifica");
    modificaStadio.style.display="none";


    function mostraModifica() {
        modificaStadio.style.display="block";
    }

    function nascondeInsertStadio() {
        divInsertStadio.style.display="none";

    }

</script>

</body>
</html>
