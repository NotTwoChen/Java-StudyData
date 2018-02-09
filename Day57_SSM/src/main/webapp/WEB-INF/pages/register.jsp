<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/8
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register" method="post">

        <label>
            <input type="text" name="username">
        </label>
        <input type="submit">

    </form>
</body>
</html>
