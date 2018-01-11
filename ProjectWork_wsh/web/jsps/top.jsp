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
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	  <link href="../../../NotTwoCloud/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	  <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	  <script src="../../../NotTwoCloud/js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
	body {
		/*background: #E4E4E4;*/
	}
	a {
		text-transform:none;
		text-decoration:none;
		color: grey;
	} 
	a:hover {
		text-decoration:underline;
	}
	li{
		border: solid 1px black;
		border-radius: 5px;
		text-align: center;
		width: 120px;
	}
	ul{
		margin-left: 5px;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;font-family: 楷体;font-size: 70px;" class="form-signin-heading">不二云书城</h1>
<nav>
<div style="font-size: 10pt;">
	<ul class="nav nav-pills">
<c:if test="${sessionScope.user == null}">
		<li role="presentation"><a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a></li>
		<li role="presentation"><a href="<c:url value='/jsps/user/register.jsp'/>" target="_parent">注册</a></li>
</c:if>
<c:if test="${sessionScope.user != null}">
		<li role="presentation">
			<a href="">您好：${sessionScope.user.username}</a>
		</li>
		<li role="presentation"><a href="<c:url value='/jsps/cart/list.jsp'/>" target="body">我的购物车</a></li>
		<li role="presentation"><a href="<c:url value='/order?method=myOrder'/>" target="body">我的订单</a></li>
		<li role="presentation"><a href="<c:url value='/user?method=quit'/>" target="_parent">退出</a></li>
	<c:if test="${sessionScope.user.state == 2}">
		<li role="presentation"><a href="<c:url value="/adminjsps/login.jsp/"/>" target="_parent">管理员后台</a></li>
	</c:if>
</c:if>
	</ul>

</div>
</nav>
  </body>
</html>
