<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/8
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>不二云首页</title>
    <link href="../../../NotTwoCloud/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../../../NotTwoCloud/js/bootstrap.min.js" type="text/javascript"></script>
    <style type="text/css">
      a{
        font-size: 20px;
        margin: 20px 0 0 50%;
      }
    </style>
  </head>
  <body>
  <h1>
    <a href="<c:url value="/jsps/user/register.jsp"/> ">不二云注册</a>
  </h1>
  <h1>
    <a href="<c:url value="/jsps/user/login.jsp"/>">不二云登录</a>
  </h1>
  <h1>
    <a href="<c:url value="/adminjsps/login.jsp"/>">管理员登录</a>
  </h1>

  </body>
</html>
