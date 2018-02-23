<%@ page import="it.fides.sportivo.entity.Cliente" %>
<%@ page import="it.fides.sportivo.services.ServicePartita" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="it.fides.sportivo.entity.Partita" %>
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
<% Cliente clio = (Cliente) request.getAttribute("cliente"); %>
<%! ServicePartitaDao daoPartita= new ServicePartitaDao();%>
<html>
<head>
    <title>Benvenuto <%= clio.getNome()  %> </title>
    <link rel="stylesheet" type="text/css" href="front-end/css/InserisciClienteStyle.css">
</head>
<body>
<h1 id="benvenuto"> Benvenuto <%= clio.getNome() %></h1>

<div class="areasquadre">
    <h1>Partite:</h1>
    <table class="listaSquadre">

        <tr>
            <th>Data</th>
            <th>Squadra home</th>
            <th>Squadra visitor</th>
        </tr>
        <%
            ArrayList<Partita> partite= daoPartita.listaPartite(3);
            for(int i=0; i<partite.size(); i++){
        %>

        <tr>
            <td><%=partite.get(i).getData_partita()%></td>
            <td><%=partite.get(i).getId_squadra_home()%></td>

        </tr>
        <%

            }
        %>
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
