<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    验证码:<input name="code" size="4">
    <img src="<s:url action="codeImg"/>"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
