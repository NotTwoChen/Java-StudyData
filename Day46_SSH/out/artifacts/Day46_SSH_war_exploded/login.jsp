<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/24
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    span{
        color: red;
    }
    li{
        list-style: none;
    }
    ul{
        float: right;
        margin-top: 5px;
    }
</style>
<head>
    <title>登录</title>
</head>
<body>
<div class="container">
    <s:form class="form-singin" action="login">
        <h2 class="form-signin-heading">登录</h2>
        <s:textfield name="user.username" class="form-control" id="inputEmail"/>
        <s:fielderror fieldName="username"/>
        <s:textfield name="user.password" class="form-control" id="inputPassword" type="password"/>
        <s:fielderror fieldName="password"/>
        <s:submit class="btn btn-lg btn-primary btn-block" value="登录"/>
    </s:form>
</div>
</body>
</html>
