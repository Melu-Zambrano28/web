<%@ page import="it.esempio.sportivo.entity.Stadio" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServiceStadioDao" %><%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 09/02/2018
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!ServiceStadioDao serviceStadi = new ServiceStadioDao();%>
<% Stadio stadio = (Stadio)request.getAttribute("stadioServlet");%>
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
<div class="areaIncasso" onmouseover="mostraSelect()" onmouseout="nascondiSelect()">

    <div id="imagineSoldi">
        <p id="titoloSoldi">TOTALE INCASSO</p>
        <a href="Incasso.jsp">
            <img src="front-end/img/soldi.jpg">
        </a>
    </div>


    <div id="selectStadio">
        <form method="get" action="Incasso" target="_self">
            <%
                ArrayList<Stadio> elencoStadi = serviceStadi.listaStadio();
            %>
            <label>Cerca Totale per stadio: </label>
            <select name="stadio" id="stadio2">
                <option value="0">Cerca Stadio</option>
                <%
                    for(int i=0; i< elencoStadi.size(); i++){
                        String nomeStadio =elencoStadi.get(i).getNome();
                        int idStadio = elencoStadi.get(i).getId();
                %>
                <option value=<%=idStadio%>><%=nomeStadio%></option>

                <%
                    }
                %>
            </select>

            <%--<input type="submit" name="invia" value="cerca" >--%>

        </form>
        <input type="submit" name="vedi" value="vedi" onclick="richiesta()">

        <div id="demo">
            <label>Totale: </label>
            <input type="text" id="scrive">
        </div>
    </div>

</div>


</div>



<script>
    var divBottoni=document.getElementById("bottoni");
    divBottoni.style.display="none";
    var divSelect= document.getElementById("selectStadio");
    divSelect.style.display="none";


    function nascondi () {
        divBottoni.style.display="none";
    }


    function mostra() {
        divBottoni.style.display="block";

    }

    function mostraSelect() {
         divSelect.style.display="block";
    }

    function nascondiSelect() {
        divSelect.style.display="none";

    }

    function richiesta() {
        var xmlhttp = new XMLHttpRequest();
        var selectValue=document.getElementById("stadio2").value;
        xmlhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status == 200) {
                var myObj = JSON.parse(this.responseText);
                document.getElementById("scrive").value = myObj.costo_biglietto;

                console.log(myObj);
            }
        };
        xmlhttp.open("GET", "http://localhost:8080/gestionaleSportivo/Incasso?stadio="+selectValue, true);
        xmlhttp.send();


    }



</script>

</body>
</html>
