<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 19/02/2018
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Risposte</title>
    <link rel="shortcut icon" href="front-end/img/gestore.jpg" type="image/ico" />
</head>
<body>
    <script>

        var risposta;
        var myObj;
        function richiesta() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    risposta = this.responseText;
                    console.log(risposta);
                    myObj = JSON.parse(risposta);
                    console.log(myObj);
                }
            };
            xmlhttp.open("GET", "http://localhost:8080/gestionaleSportivo/inserisciSquadra", true);
            xmlhttp.send();
        }

    </script>

    <h1>Vediamo</h1>
    <button onclick="richiesta()">Ok</button>

</body>
</html>
