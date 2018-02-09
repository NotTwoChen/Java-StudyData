<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/5
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="注册">
    </form>
</body>
</html>
