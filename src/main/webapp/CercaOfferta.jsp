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
</head>
<body>

<div id="cercaSconto">
    <table>
        <form  method="post" action="">
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
                <td><input type="date" name="cognomeCliente"/></td>

            </tr>

            <tr>
                <td>
                    <a href="MostraPartiteCliente.jsp">
                         <input type="button" name="bottoneVisualizza" value="Seleziona partita">
                    </a>
                </td>
            </tr>
            <div id="rispostaServer">
                <td><label>cosa sucede: </label></td>
                <td><%=request.getParameter("data")%></td>
            </div>


            <tr><!-- colonna -->
                <td><input type="submit" name="cercaOfferta" value="Cerca"></td>
                <td><input type="reset" name="cancella" value="Cancella"></td>
            </tr>
        </form>

    </table>

</div>

    <script>
        var divRispostaServer= document.getElementById("rispostaServer");
        console.log(divRispostaServer);
            divRispostaServer.style.display="none";



        function  mostaRispostaServer() {
            divRispostaServer.style.display="block";

        }
    </script>

</body>
</html>
