<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>不二云登录</title>
    
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
  </head>
  
  <body>


  <div class="container">
	  <a href="<c:url value="/adminjsps/login.jsp"/>">管理员登录</a>
	  <form class="form-signin" action="<c:url value="/user"/>" method="post">
		  <h2 class="form-signin-heading">不二云登录</h2>
		  <h3 class="form-signin-heading">${requestScope.message}</h3>
		  <input type="hidden" name="method" value="login">
		  <input id="inputEmail" class="form-control" placeholder="Username" name="username" value="${requestScope.form.username}" type="text">
		  <input id="inputPassword" class="form-control" placeholder="Password" name="password" type="password">
		  <button class="btn btn-lg btn-primary btn-block" type="submit">登&nbsp;&nbsp;录</button>
	  </form>
	  <a  style="float: left;margin-top: 0" href="<c:url value="/jsps/user/register.jsp"/> ">没有账号?</a>
  </div>
  </body>
</html>
