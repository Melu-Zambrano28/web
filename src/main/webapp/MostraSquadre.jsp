<%@ page import="it.fides.sportivo.entity.Squadra" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServiceSquadraDao" %>
<%@ page import="it.fides.sportivo.repository.DataSourceSingleton" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="it.fides.sportivo.entity.Stadio" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServiceStadioDao" %><%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 12/02/2018
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!ServiceStadioDao daoStadio= new ServiceStadioDao();%>
<%!ServiceSquadraDao daoSquadra = new ServiceSquadraDao(); %>
<html>
<head>
    <title>Mostra Squadra</title>
    <link href="front-end/css/MostraSquadrasStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Identifica il codice della squadra/Stadio assocciato al nome:</h1>
<div class="areasquadre">
    <h1>Codice Partita:</h1>
    <table class="listaSquadre">

    <tr>
        <th>id</th>
        <th>Nome Squadre</th>

    </tr>
    <%
       ArrayList<Squadra> squadre=daoSquadra.listaSquadra();
       for(int i=0; i<squadre.size(); i++){
    %>

    <tr>
        <td><%=squadre.get(i).getId()%></td>
        <td><%=squadre.get(i).getNome()%></td>

    </tr>
    <%

        }
    %>
</table>
</div>

<div class="areastadio">
    <h1>Codice stadio: </h1>
    <table class="listaStadio">

        <tr>
            <th>id</th>
            <th>Nome Stadi:</th>

        </tr>
        <%
            ArrayList<Stadio> listaStadi=daoStadio.listaStadio();
            for(int i=0; i<listaStadi.size(); i++){
        %>

        <tr>
            <td><%=listaStadi.get(i).getId()%></td>
            <td><%=listaStadi.get(i).getNome()%></td>

        </tr>
        <%

            }
        %>
    </table>

</div>
</body>
</html>
