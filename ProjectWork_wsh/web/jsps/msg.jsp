<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>不二云账号激活</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="../../../NotTwoCloud/css/bootstrap.min.css" rel="stylesheet" type="text/css">
      <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
      <script src="../../../NotTwoCloud/js/bootstrap.min.js" type="text/javascript"></script>
      <style type="text/css">
          a{
              font-size: 20px;
              margin: 20px 0 0 40%;
          }
          ul{

          }
      </style>
  </head>

  <body>
  <c:if test="${requestScope.message != null}">
        <h1>${requestScope.message}</h1>
  </c:if>
  <c:if test="${requestScope.message == null}">
      <h1 style="margin: 0 35%">恭喜您!您的账号已经成功激活!~</h1>
  </c:if>
  <h1>
  <a href="<c:url value='/index.jsp'/>">跳转到不二云书城</a>
  </h1>
  <h1>
  <a href="<c:url value='/jsps/user/login.jsp'/>">跳转到登录页面</a>
  </h1>
  <h1>
  <a href="<c:url value='/jsps/user/register.jsp'/>">跳转到注册页面</a>
  </h1>


  </body>
</html>
