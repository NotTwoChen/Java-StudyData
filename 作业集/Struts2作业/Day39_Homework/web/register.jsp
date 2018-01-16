<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/15
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="../../../js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="../../../js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
    .container{
        width:300px;
        margin-top: 200px;
    }
    .form-signin-heading{
        margin-bottom: 20px;
    }
    .form-control{
        margin-bottom: 20px;
    }
    a{
        float: right;
        margin-top: 32px;
    }
</style>
<head>
    <title>register</title>
</head>
<body>
<div class="container">
    <form class="form-signin" action="<c:url value="register.action"/>" method="post">
        <h2 class="form-signin-heading">注册</h2>
        <h6 class="form-signin-heading" style="color: red">${requestScope.message}</h6>
        <input type="hidden" name="method" value="register">
        <input id="inputEmail" class="form-control" placeholder="Username" name="username" value="${requestScope.form.username}" type="text">
        <input id="inputPassword" class="form-control" placeholder="Password" name="password" type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">注&nbsp;&nbsp;册</button>
    </form>
    <a href="<c:url value="/login.jsp"/>">已有账号!</a>
</div>

</body>
</html>
