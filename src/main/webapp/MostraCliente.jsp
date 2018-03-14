<%@ page import="it.esempio.sportivo.entity.Cliente" %>
<%@ page import="it.esempio.sportivo.services.ServicePartita" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="it.esempio.sportivo.entity.Partita" %>
<%@ page import="java.util.ArrayList" %><%--
<%@ page import="it.fides.sportivo.entity.Partita" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServicePartitaDao" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/02/2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%! ServicePartitaDao daoPartita= new ServicePartitaDao();%>
<html>
<head>
    <%
        Cliente cliente =(Cliente) request.getAttribute("cliente");
    %>
    <title>Benvenuto></title>
    <link rel="stylesheet" type="text/css" href="front-end/css/InserisciClienteStyle.css">
</head>
<body>
<h1 id="benvenuto"> Benvenuto</h1>

<div class="areasquadre">
    <h1>Partite:</h1>
    <table class="listaSquadre">

        <tr>
            <th>Data</th>
            <th>Squadra home</th>
            <th>Squadra visitor</th>
        </tr>


    </table>
</div>

<form action="InserisciCliente.jsp">
    <input type="submit" value="Go to Home" />
</form>


    <div id="demo">
        <h2>The XMLHttpRequest for Squadre in A Object</h2>
        <button type="button" onclick="loadDoc()">Change Content</button>
    </div>

    <script>
        var giasone;
        var listaPartite;
        function loadDoc() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    giasone = this.responseText;
                    listaPartite = JSON.parse(giasone);
                    document.getElementById("demo").innerHTML =
                        this.responseText;
                }
            };
            xhttp.open("GET", "/ajaxPartita", true);
            xhttp.send();
        }

    </script>


</body>
</html>
