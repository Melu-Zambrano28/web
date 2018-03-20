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
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario")== null){
        response.sendRedirect("LoginGestore.jsp");
    }

%>
<h1 id="registroSquadra">Registro Squadra</h1>


<div class="partita">
    <div class="imaginesPartita">
        <a href="#registraSquadra">
            <img src="front-end/img/squadra.jpg">
        </a>
    </div>
</div>

<div class="inserisciSquadra">

    <h1>INSERISCI SQUADRA</h1>

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
