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
</head>
<body>
    <script>
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200 && this.status==306) {
                var myObj = JSON.parse(this.responseText);
                console.log(myObj.getNome());
            }
        };
        xmlhttp.open("GET", "http://localhost:8080/gestionaleSportivo/inserisciSquadra", true);
        xmlhttp.send();

    </script>

    <h1 onchange="xmlhttp.responseText"></h1>

</body>
</html>
