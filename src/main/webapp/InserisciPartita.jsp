<%@ page import="it.esempio.sportivo.servicesimplementation.ServicePartitaDao" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServiceSquadraDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.esempio.sportivo.entity.Squadra" %>
<%@ page import="it.esempio.sportivo.servicesimplementation.ServiceStadioDao" %>
<%@ page import="it.esempio.sportivo.entity.Stadio" %><%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 14/02/2018
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!ServicePartitaDao partita= new ServicePartitaDao();%>
<%!ServiceSquadraDao squadra= new ServiceSquadraDao();%>
<%!ServiceStadioDao stadio= new ServiceStadioDao();%>

<html>
<head>
    <title>Inserisci Partita</title>
    <link href="front-end/css/InserisciPartitaStyle.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
</head>
<body>
<h1 id="registroPartita">Registro Partita</h1>

<div class="partita">
    <div class="imaginesPartita">


        <a href="#registraPartita">
            <img src="front-end/img/partita.jpg">
        </a>
    </div>
</div>

    <div class="registraPartita">
        <h1>INSERISCI PARTITA</h1>
        <table>

            <form  name="registraPartita" method="get" action="/gestionaleSportivo/inserisciPartita">
                <tr>
                    <td><label>Data partita: </label></td>
                    <td><input type="datetime-local" min='2018-01-01' name="dataPartita" id =" dataPartita"/></td>

                </tr>
                <tr>
                    <td>
                        <label>Home: </label>
                    </td>

                  <td>  <select name="sq_Home">
                      <%
                          ArrayList<Squadra> elencoSquadre = squadra.listaSquadra();
                          ArrayList<Stadio> elencoStadio = stadio.listaStadio();
                          for(int i=0; i<elencoSquadre.size(); i++){
                              String nomehome=elencoSquadre.get(i).getNome();
                              int idHome=elencoSquadre.get(i).getId();
                      %>

                        <option value=<%=idHome%>><%=nomehome%></option>
                      <%
                          }
                      %>

                  </select>
                  </td>

                </tr>
                <tr>
                    <td>
                        <label>Visitor: </label>
                    </td>

                    <td>  <select name="sq_Visitor">

                        <%
                            for(int i=0; i<elencoSquadre.size(); i++){
                                String nomeVisitor=elencoSquadre.get(i).getNome();
                                int idVisitor=elencoSquadre.get(i).getId();
                        %>


                        <option value=<%=idVisitor%>><%=nomeVisitor%></option>

                     <%
                         }
                     %>

                    </select>
                    </td>

                </tr>

                <tr>
                    <td>
                        <label>Home: </label>
                    </td>

                    <td>  <select name="stadio">

                        <%
                            for(int i=0; i<elencoStadio.size(); i++){
                                String nomeStadio=elencoStadio.get(i).getNome();
                                int idStadio=elencoStadio.get(i).getId();
                        %>

                        <option value=<%=idStadio%>>
                            <%=nomeStadio%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    </td>

                </tr>

                <tr><!-- colonna -->
                    <td><input type="submit" name="inviaPartita" value="Invia"></td>
                    <td><input type="reset" name="cancellaPartita" value="Cancella"></td>
                </tr>
            </form>
        </table>

    </div>
</body>
</html>
