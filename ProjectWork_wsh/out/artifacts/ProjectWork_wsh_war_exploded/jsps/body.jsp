<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
      <link href="../../../NotTwoCloud/css/bootstrap.min.css" rel="stylesheet" type="text/css">
      <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
      <script src="../../../NotTwoCloud/js/bootstrap.min.js" type="text/javascript"></script>
      <script type="text/javascript">
          <c:if test="${sessionScope.user == null}">alert("请先登录!~");</c:if>
      </script>
      <style type="text/css">
          body{
              margin-top: 110px;
          }
          p{
              margin-left: 45px;
              font-size: 25px;
          }

      </style>
  </head>
  
  <body>

    <p>
        In NotTwoCloud, you can find more information about the books you buy,
    </p>
    <p>
        because NotTwoCloud is a website that has its own unique way of selling books and functions.
    </p>
    <p>
        Such as user registration and login function.
    </p>
  </body>
</html>
