<%@ page import="it.fides.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServiceSquadraDao" %>
<%@ page import="it.fides.sportivo.servicesimplementation.ServiceStadioDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.fides.sportivo.entity.Partita" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="com.sun.webkit.network.Util" %>
<%@ page import="it.fides.sportivo.Util.Util_Data_Time" %><%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 26/02/2018
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!ServicePartitaDao partita= new ServicePartitaDao();%>
<%!%>
<%!int id_Partita1 =0;%>
<%!GregorianCalendar data=null;%>
<%! int capienza = 0;%>
<%!String nomeHome="";%>
<%!String nomeVisitor="";%>
<%!String nomeStadio="";%>
<%!double prezzo=0;%>



<html>
<head>
    <title>Visualizza Partita</title>
    <link href="front-end/css/VisualizzaPartitaStyle.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
    <%--<script type="text/javascript" src="front-end/js/FunzioniPartite.js"></script>--%>


</head>
<body>
<h1 id="titulo">Visualizza partita</h1>
<script>


    var url =location.search.substring(1);
    var vars =url.split("=");
    console.log(vars);
    var tipologia=vars[1];
    console.log("questo???"+tipologia);
    var cronologico=document.getElementById("cronologico");
    console.log(cronologico);
    var capienza=document.getElementById("capienza");
    console.log(capienza);



</script>


    <div id="capienza">
        <h1>Secondo la capienza:</h1>
        <table>
            <tr>
                <th>Codice Partita</th>
                <th>Data Partita</th>
                <th>Stadio</th>
                <th>Capienza</th>
                <th>Home</th>
                <th>Visitor</th>
                <th>Prezzo della Partita</th>
            </tr>
            <tr>
                <%
                    ArrayList<Partita> elencoPartita =partita.elencoOrdinatoPerData();
                    for(int i=0; i<elencoPartita.size(); i++){
                        id_Partita1 =elencoPartita.get(i).getId();
                        data =elencoPartita.get(i).getData_partita();
                        capienza = elencoPartita.get(i).getStadio().getCapienza();
                        nomeHome=elencoPartita.get(i).getSquadra_home().getNome();
                        nomeVisitor=elencoPartita.get(i).getSquadra_visitor().getNome();
                        nomeStadio=elencoPartita.get(i).getStadio().getNome();
                        prezzo=elencoPartita.get(i).getStadio().getCosto_biglietto();


                %>
                <td><%=id_Partita1%></td>
                <td><%=Util_Data_Time.convertiGregorianCalendar_String(data)%></td>
                <td><%=nomeStadio%></td>
                <td style="background: burlywood"><%=capienza%></td>
                <td><%=nomeHome%></td>
                <td><%=nomeVisitor%></td>
                <td><%=prezzo%></td>
            </tr>

            <%
                }
            %>

        </table>

    </div>


    <div id="cronologico">
        <h1>In ordine cronologico</h1>

        <table>
            <tr>
                <th>Codice Partita</th>
                <th>Data Partita</th>
                <th>Stadio</th>
                <th>Home</th>
                <th>Visitor</th>
                <th>Prezzo della partita</th>
            </tr>
            <tr>
                <%
                    ArrayList<Partita> elencoPartita2 =partita.elencoOrdinatoPerData();
                    for(int i = 0; i< elencoPartita2.size(); i++){
                        id_Partita1 = elencoPartita2.get(i).getId();
                        data = elencoPartita2.get(i).getData_partita();
                        nomeHome= elencoPartita2.get(i).getSquadra_home().getNome();
                        nomeVisitor= elencoPartita2.get(i).getSquadra_visitor().getNome();
                        nomeStadio= elencoPartita2.get(i).getStadio().getNome();
                        prezzo=elencoPartita.get(i).getStadio().getCosto_biglietto();



                %>
                <td><%=id_Partita1%></td>
                <td style="background: burlywood"><%=Util_Data_Time.convertiGregorianCalendar_String(data)%></td>
                <td><%=nomeStadio%></td>
                <td><%=nomeHome%></td>
                <td><%=nomeVisitor%></td>
                <td><%=prezzo %></td>
            </tr>

            <%
                }
            %>

        </table>

    </div>

<script>
    var divCapienza=document.getElementById("capienza");
    var divCronologico=document.getElementById("cronologico");

    if(tipologia=="capienza"){
        divCronologico.style.display="none";
    }else{
        divCapienza.style.display="none"
    }


</script>

</body>
</html>
