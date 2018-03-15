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
    <title>Gestore</title>
    <link href="front-end/css/GestoreStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="front-end/js/FunzioniPartite.js"></script>
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
</head>
<body>
<h1>GESTIONE</h1>


<div class="stadio">

    <div class="imaginestadio">

        <p id="inserisciStadio">INSERISCI UN STADIO</p>
        <a href="InserisciStadio.jsp">
            <img src="front-end/img/stadio.jpg">
        </a>
    </div>


</div>

<div class="squadra">

    <div class="imaginesquadra">

        <p id="inserisciSquadra">INSERISCI SQUADRA</p>
        <a href="InserisciSquadra.jsp">
            <img src="front-end/img/squadra.jpg">
        </a>
    </div>


</div>


<div class="partita">
    <div class="imaginesPartita">

        <p id="inserisciPartita">INSERISCI PARTITA</p>
        <a href="InserisciPartita.jsp">
            <img src="front-end/img/partita.jpg">
        </a>
    </div>
</div>

<div class="areaVisualizza" onmouseover="mostra()" onmouseout="nascondi()">
        <div id="imagineVisualizza">
            <p id="visualizza">VISUALIZZA PARTITA</p>
            <a href="" onclick="mostra()">
                <img src="front-end/img/cerca.png">
            </a>
        </div>

            <div id="bottoni">

                <label>Cerca per capienza: </label>
                <a href="VisualizzaPartita.jsp?tipologia=capienza">
                    <button name="BotoneCapienza" type="button" formtarget="_blank">Cerca</button>
                </a>
                <br>

                <label>Cerca in ordine Coronologico: </label>
                <a href="VisualizzaPartita.jsp?tipologia=cronologico">
                    <button name="botoneConologico" type="button" formtarget="_blank" value="tablla1">Cerca</button>
                </a>

            </div>



</div>
<div class="areaIncasso">

    <div id="imagineSoldi">
        <p id="titoloSoldi">TOTALE INCASSO</p>
        <a href="Incasso.jsp">
            <img src="front-end/img/soldi.jpg">
        </a>
    </div>



</div>

<script>
    var divBottoni=document.getElementById("bottoni");
    function nascondi () {
        divBottoni.style.display="none";
    }


    function mostra() {
        divBottoni.style.display="block";
    }
</script>

</body>
</html>
