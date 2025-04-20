<%--
  Created by IntelliJ IDEA.
  User: Lisa
  Date: 20.04.2025
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Авторизация</title>
</head>
<body>
<div style="margin: 150px" >
    <h1>Авторизация</h1>
    <form action="<c:url value='/login'/>" method="post" >
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Введите логин</label>
    <input name="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>
<div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Введите пароль</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
</div>
<button type="submit" class="btn btn-primary">Войти</button>
<div class="mt-3 text-center">
    <a href="<c:url value='/registration'/>">Создать аккаунт</a>
</div>
</form>
</div>

</body>
</html>
