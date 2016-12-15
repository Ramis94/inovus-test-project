<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: GRamis
  Date: 12.12.2016
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

    <p class="error">${error}</p>
    <form:form action="/sign-up" method="POST" commandName="sign-up">
        <table>
            <tbody>
            <tr>
                <td>Имя пользователя: </td>
                <td><input type="text" name="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Пароль: </td>
                <td><input type="password" name="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Повтор пароля:</td>
                <td><input type="password" name="confirmPassword"/></td>
                <td><form:errors path="confirmPassword" cssClass="error"/><form:errors path="valid" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Зарегистрироваться" /></td>
                <td><a href="/sign-in">Войти</a></td>
            </tr>
            </tbody>
        </table>
    </form:form>

</body>
</html>
