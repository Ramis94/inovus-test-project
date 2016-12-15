<%--
  Created by IntelliJ IDEA.
  User: GRamis
  Date: 12.12.2016
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привет:)</title>
    <script src="/resources/js/main.js"></script>
</head>
<body>

    ${error}

    <table>
        <tbody>
            <tr>
                <td><p id="day">Здравствуйте</p></td>
                <td>${userName}</td>
            </tr>
        </tbody>
    </table>

    <form action="/logout" method="get">
        <button type="submit">Выйти</button>
    </form>

    <script>
        getDay();
    </script>
</body>
</html>
