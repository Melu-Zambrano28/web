<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="it.esempio.sportivo.entity.Partita" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: User
  Date: 15/03/2018
  Time: 17:48
=======
  User: Training
  Date: 15/03/2018
  Time: 15:26
>>>>>>> 50f1bc22e057da4dd1082e11d76846c4846ec37c
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<%  String prezzo = request.getParameter("prezzo"); %>
<%! Date dataPartitaData = null; %>
<% Partita partita = (Partita) request.getAttribute("PartitaSel"); %>
<% dataPartitaData = partita.getData_partita().getGregorianChange(); %>
<c:set var = "DATA" value = "<% = dataPartitaData %>" />
<head>
    <title>Acquista Biglietto</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0-2/css/bootstrap.min.css">
    <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>

<h1 style="text-align: center">Informazioni Biglietto partita selezionata </h1>
<p> </p>
<div class="container">
    <div class="well">
        <form action="acquistaBiglietto" method="post">
            <label>Data partita: <%= dataPartitaData %> </label><br>
            <label>Squadra home: ${PartitaSel.squadra_home.nome}</label><br>
            <label>Squadra visitor: ${PartitaSel.squadra_visitor.nome}</label><br>
            <label>Prezzo: <%= prezzo %></label><br>
            <label>Acquistare: </label><input type="radio" name="acquistato-prenotato" value="2" checked="checked">
            <label>Prenotare: </label><input type="radio" name="acquistato-prenotato" value="3"><br>
            <input type="hidden" name="id-partita" value="${PartitaSel.id}">
            <input type="hidden" name="id-cliente" value="${ClienteSel.id}">
            <input type="hidden" name="nome" value="${ClienteSel.nome}">
            <input type="hidden" name="cognome" value="${ClienteSel.cognome}">
            <input type="hidden" name="prezzo" value="<%= prezzo %>">
            <input type="button" name="indietro" value="Indietro" onclick="window.location.href='/gestionaleSportivo/MostraCliente.jsp'">
            <input type="submit" name="procedi" value="Procedi" class="ip"></input>
        </form>
    </div>
</div>




</body>
</html>
