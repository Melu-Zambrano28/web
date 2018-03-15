<%@ page import="it.esempio.sportivo.servicesimplementation.ServiceStadioDao" %>
<%@ page import="it.esempio.sportivo.entity.Stadio" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 14/03/2018
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!ServiceStadioDao serviceStadi = new ServiceStadioDao();%>
<% Stadio stadio = (Stadio)request.getAttribute("stadioServlet");%>

<html>
<head>
    <title>Incasso</title>
    <link href="front-end/css/GestoreStyle.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
</head>
<body>
    <h1>Cerca Incasso totale per Stadio</h1>

<div id="selectStadio">
    <form method="get" action="Incasso" target="_self">
        <%
            ArrayList<Stadio>elencoStadi = serviceStadi.listaStadio();
        %>
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
</div>
    <div id="demo">
        <input type="text" id="scrive">
        <table>
            <tr>
                <th>Nome stadio</th>
                <th>capienza</th>
                <th>Totale incasso</th>
            </tr>

        </table>

    </div>
<script>



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
