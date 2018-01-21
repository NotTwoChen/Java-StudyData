<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/16
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态参数</title>
</head>
<body>
<h1>访问active.action</h1>
<form action="active.action" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="submit">
</form>
<h1>访问ognl.action</h1>
<form action="ognl.action" method="post">
    <input type="text" name="student.name">
    <input type="text" name="student.age">
    <input type="submit" value="submit">
</form>
<h1>访问model.action</h1>
<form action="model.action" method="post">
    <input type="text" name="name">
    <input type="text" name="age">
    <input type="submit" value="submit">
</form>
<h1>访问val.action</h1>
<form action="val.action" method="post">
    <input type="text" name="student.name">
    <input type="text" name="student.age">
    <input type="submit" value="submit">
</form>
<h1>访问single.action</h1>
<form action="single.action" method="post">
    <input type="text" name="single">
    <input type="submit" value="submit">
</form>
<h1>访问decVal.action</h1>
<form action="decVal.action" method="post">
    <input type="text" name="name">
    <input type="submit" value="submit">
</form>

</body>
</html>
