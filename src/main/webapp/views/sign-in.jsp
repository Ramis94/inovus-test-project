<%--
  Created by IntelliJ IDEA.
  User: GRamis
  Date: 12.12.2016
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

    <%if("true".equals(request.getParameter("info"))){
        out.println("<p class=\"info\">Вы вышли из приложения</p>");
    }%>

    <p class="warning">Необходимо ввести учетные данные</p>

    <%if("true".equals(request.getParameter("error"))){
        out.println("<p class=\"error\">Имя пользователя и пароль не подходит</p>");
    }%>

    ${error}

    <form action="/j_spring_security_check" method="POST">
        <table>
            <tbody>
            <tr>
                <td>Имя пользователя:</td>
                <td><input type="text" name="j_username" value="${userName}"></td>
                <td><a href="/sign-up">Регистрация</a></td>
            </tr>
            <tr>
                <td>Пароль: </td>
                <td><input type="password" name="j_password" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Войти" /></td>
            </tr>
            </tbody>
        </table>
    </form>


</body>
</html>
