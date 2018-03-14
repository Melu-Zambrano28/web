<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 02/03/2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cerca Offerte</title>
    <link rel="shortcut icon" href="front-end/img/lupa.png" type="image/ico" />


</head>
<body>

<div id="cercaSconto">
    <table>
        <form  method="post" action="sconto">
            <tr>
                <td>
                    <a href="MostraPartiteCliente.jsp">
                        <input type="button" name="bottoneVisualizza" value="Seleziona data partita">
                    </a>
                </td>
            </tr>
            <tr>
                <td><label>Nome: </label></td>
                <td><input type="text" name="nomeCliente" /></td>

            </tr>
            <tr>
                <td><label>Cognome </label></td>
                <td><input type="text" name="cognomeCliente"/></td>

            </tr>

            <tr>
                <td><label>Data di nascita </label></td>
                <td><input type="date" name="dataNascita"/></td>

            </tr>

            <div id="rispostaServer">
                <td><label>Data Partita: </label></td>
                <td><input type="text" name="dataPartita" value=<%=request.getParameter("data")%>></td>
            </div>


            <tr><!-- colonna -->
                <td><input type="submit" name="cercaOfferta" value="Cerca"></td>
                <td><input type="reset" name="cancella" value="Cancella"></td>
            </tr>
        </form>

    </table>

</div>



</body>
</html>
