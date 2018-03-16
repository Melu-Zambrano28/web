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
    <title>Ciao <% if (clio != null) { nomeCliente = clio.getNome(); cognomeCliente = clio.getCognome();
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


<div id="demo">
    <h2>Visualizzatore delle partite</h2>
    <!--<button type="button" id="btn-ajax" class="genCenter"> Mutazione </button> -->
    <select id="selezione" name="selezione" class="genCenter" autofocus>
        <option value="">Selezione l'ordine delle partite ...</option>
        <option value="orario">Ordina in base all'orario</option>
        <option value="stadio.id">Ordina in base allo stadio</option>
        <option value="lessicografico">Ordina in base all'ordine lessicografico</option>
    </select>
    <select id="selezione-stadio">
        <option>Seleziona uno stadio ...</option>
        <c:forEach items="${stadio}" var="elem">
            <option>${elem.nome}</option>
        </c:forEach>
    </select>
    <div>




</div>

<form action="acquistaBiglietto" method="post" id="maschera">
    <div id="form">
        <br><label>Data:</label><input type="text" placeholder="nome" name="nome" class="zebra" ><br>
        <br><label>Squadra home</label><input type="text" placeholder="cognome" name="cognome" class="zebra"><br>
        <br><label>Squadra visitor:</label><input type="date" name="data-nascita" class="zebra"><br>
        <br><label><input type="submit" value="Acquista" class="button" id="acquista"></label>
        <br><label><input type="submit" value="Prenota" class="button" id="prenota"></label>
        <button type="reset" value="Reset">Reset</button>
    </div>
</form>

<script>

    //Assegnamento dei valori di java a delle variabili globali javascript
    var nomeCliente = "<%=  nomeCliente %>";
    var cognomeCliente = "<%= cognomeCliente %>";
</script>

<script type="text/javascript" src="front-end/js/MostraPartita.js"></script>



<center>
<%@ include file = "footer.jsp" %>

