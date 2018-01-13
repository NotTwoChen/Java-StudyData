<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.wsh.category.domain.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
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
		*{
			font-size:10pt;
			text-align: center;
		}
		a {
			text-decoration: none;
		}
		.list-group{
			border: solid 1px black;
			border-radius: 5px;
		}
	</style>
  </head>
  
  <body>
  <c:if test="${sessionScope.user != null}">
	  <div class="list-group">
		  <a class="list-group-item" href="<c:url value='/jsps/book/list.jsp?pageCode=1&cid=0'/>">全部分类</a>
	  </div>
	  <c:forEach items="${requestScope.categoryList}" var="category" begin="0" end="${requestScope.categoryList.size()}" step="1">
		  <div class="list-group">
			  <a class="list-group-item" href="<c:url value="/jsps/book/list.jsp?pageCode=1&cid=${category.cid}"/>">${category.cname}</a>
		  </div>
	  </c:forEach>
  </c:if>


  </body>
</html>
