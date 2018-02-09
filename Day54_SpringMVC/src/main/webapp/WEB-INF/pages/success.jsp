<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/5
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <h1>success!!!</h1>
    <h1>欢迎回家:${user.username}</h1>
    <form action="" method="post">
        <input type="text" name="username" value="${user.username}">
        <input type="text" name="password" value="${user.password}">
    </form>
</body>
</html>
