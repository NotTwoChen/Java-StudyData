<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="../../../NotTwoCloud/css/bootstrap.min.css" rel="stylesheet" type="text/css">
      <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
      <script src="../../../NotTwoCloud/js/bootstrap.min.js" type="text/javascript"></script>

  </head>
  
  <body style="">
  <h1 style="text-align: center;font-family: 楷体;font-size: 70px;" class="form-signin-heading">不二云书城后台管理</h1>
  <nav>
      <div style="font-size: 12pt;">
          <ul class="nav nav-pills">
              <c:if test="${sessionScope.admin == null}">
                  <li role="presentation"><a href="<c:url value='/adminjsps/login.jsp'/>" target="_parent">登录</a></li>
              </c:if>
              <c:if test="${sessionScope.admin != null}">
                  <li role="presentation">
                      <a href="">管理员：${sessionScope.admin.username}</a>
                  </li>
              </c:if>
          </ul>
      </div>
  </nav>
  </body>
</html>
