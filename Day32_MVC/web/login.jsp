<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/5
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<form action="user" method="post">
    <input type="hidden" name="method" value="login">
    账号:
    <input type="text" name="username">
    <br>
    密码:
    <input type="password" name="password">
    <br>
    <input type="submit">
</form>
</body>
</html>
