<%@ page import="it.esempio.sportivo.entity.Cliente" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="it.esempio.sportivo.entity.Cliente" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.esempio.sportivo.entity.Stadio" %>
<%--
<%@ page import="it.fides.sportivo.servicesimplementation.ServicePartitaDao" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/02/2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% Cliente clio = (Cliente) request.getAttribute("cliente"); %>
<%! String nomeCliente = ""; %> <%! String cognomeCliente = ""; %>
<html>
<head>
    <title>Ciao <% if (clio != null) {
        nomeCliente = clio.getNome();
        cognomeCliente = clio.getCognome();
    } %> <%= nomeCliente %>
    </title>
    <link rel="stylesheet" type="text/css" href="front-end/css/InserisciClienteStyle.css">
    <link rel="stylesheet" type="text/css" href="front-end/css/MostraCliente.css">
    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="webjars/kendo-ui-core/2016.3.1317/js/kendo.ui.core.min.js"></script>
</head>
<body>

<header class="header">
    <a href="Gestore.jsp" class="header-sinistra">Gestore</a>
    <div class="header-destra">
        <a href>Contatti</a>
        <a href>Accedi</a>
        <a href>Su di noi</a>
    </div>
</header>

<h1 id="benvenuto"> Ciao <%=  nomeCliente %>   ${cliente.cognome}
</h1>


<div id="menu-acquisti" class="visibile">
    <button class="btn-cliente" id="biglietto">Biglietteria</button>
    <br>
    <button class="btn-cliente" id="acquisto">I miei acquisti</button>
    <br>
    <button class="btn-cliente" id="prenotazione">Le mie prenotazioni</button>
</div>


<div id="demo" class="nascosto">
    <h2>Visualizzatore delle partite</h2>
    <!--<button type="button" id="btn-ajax" class="genCenter"> Mutazione </button> -->
    <select id="selezione" name="selezione" class="genCenter" autofocus>
        <option value="">Selezione l'ordine delle partite ...</option>
        <option value="orario">Ordina in base all'orario</option>
        <option value="stadio.id">Ordina in base allo stadio</option>
        <option value="concat(sq_home, sq_visitor)">Ordina in base all'ordine lessicografico</option>
    </select>
    <select id="selezione-stadio">
        <option>Seleziona uno stadio ...</option>
        <c:forEach items="${stadio}" var="elem">
            <option>${elem.nome}</option>
        </c:forEach>
    </select>
    <div>

    </div>
</div>

<div class="nascosto" id="partita-stadio">
    <form id="formo" method="post" action="calcolaPrezzo"><input type="hidden" name="nome" class="zebra" value=""><input
            type="hidden" name="cognome" class="zebra" value="">
        <table border="4" id="tabella" class="center">
            <tbody>
            <th>Squadra Home</th>
            <th>Squadra Visitor</th>
            <th>Data partita</th>
            <th>Stadio</th>
            <tr>
                <td>Astana</td>
                <td>Benevento</td>
                <td>23/08/2018 -- 09:00:00 PM</td>
                <td>Olimpico</td>
                <input type="radio" value="13" name="id-partita" class="radioStyle"><input type="hidden" class="zebra"
                                                                                           value="13">
            </tr>
            </tbody>
        </table>
        <input type="submit" id="checkout" value="Procedi"></form>
</div>


<div id="maschera" class="visibile">
    <form action="acquistaBiglietto" method="post">
        <div id="form">
            <br><label>Data:</label><input type="text" placeholder="nome" name="nome" class="zebra"><br>
            <br><label>Squadra home</label><input type="text" placeholder="cognome" name="cognome" class="zebra"><br>
            <br><label>Squadra visitor:</label><input type="date" name="data-nascita" class="zebra"><br>
            <br><label><input type="submit" value="Acquista" class="button" id="acquista"></label>
            <br><label><input type="submit" value="Prenota" class="button" id="prenota"></label>
            <button type="reset" value="Reset">Reset</button>
        </div>
    </form>

</div>

<script>
    //Assegnamento dei valori di java a delle variabili globali javascript
    var nomeCliente = "<%=  nomeCliente %>";
    var cognomeCliente = "<%= cognomeCliente %>";
</script>

<script type="text/javascript" src="front-end/js/MostraPartita.js"></script>


<center>
    <%@ include file="footer.jsp" %>

