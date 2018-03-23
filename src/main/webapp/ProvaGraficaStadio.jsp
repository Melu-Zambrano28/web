<%--
  Created by IntelliJ IDEA.
  User: Fides
  Date: 23/03/2018
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grafica</title>
    <link href="front-end/css/Grafica.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="stadio">
        <%
            for(int i=0; i<=200; i++){

        %>
            <div>
                <h1><%=i%></h1>
            </div>
        <%
            }
        %>
    </div>

</body>
</html>
