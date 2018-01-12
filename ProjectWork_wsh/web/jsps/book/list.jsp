<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
    img{
        height: 150px;
    }
    ul{
        width: 820px;
        float: left;
    }
    li{
        float: left;
        list-style: none;
    }
    a{
        text-decoration-line: none;
        color: red;
    }
    span{
        text-align: center;
        line-height: 34px;
        width: 34px;
        height: 34px;
        border: solid 1px grey;
        border-radius: 5px;
        cursor:pointer;
        display: block;
    }
    span:hover{
        background-color: grey;
    }
</style>
  </head>
  
  <body>
  <nav>
      <ul>
          <c:if test="${requestScope.page > 6}">
              <li>
                  <a href="<c:url value="/book?method=findAll&page=1"/>">
                      <span>&laquo;&laquo;</span>
                  </a>
              </li>
          </c:if>
          <c:if test="${requestScope.page > 1}">
              <li>
                  <a href="<c:url value="/book?method=findAll&page=${requestScope.page-1}"/>" >
                      <span>&laquo;</span>
                  </a>
              </li>
          </c:if>
          <c:if test="${requestScope.pages > 1}">
          <c:set value="" var="begin"/>
          <c:set value="" var="end"/>
          <c:if test="${requestScope.page < 6 && requestScope.pages < 11}">
              <c:set value="1" var="begin"/>
              <c:set value="${requestScope.pages}" var="end"/>
          </c:if>
          <c:if test="${requestScope.page < 6 && requestScope.pages > 10}">
              <c:set value="1" var="begin"/>
              <c:set value="10" var="end"/>
          </c:if>
          <c:if test="${requestScope.page > 5 && requestScope.page + 4 < requestScope.pages}">
              <c:set value="${requestScope.page-5}" var="begin"/>
              <c:set value="${requestScope.page+4}" var="end"/>
          </c:if>
          <c:if test="${requestScope.page + 4 >= requestScope.pages && requestScope.pages > 5}">
              <c:set value="${requestScope.pages-9}" var="begin"/>
              <c:set value="${requestScope.pages}" var="end"/>
          </c:if>
          <c:forEach var="page" begin="${begin}" end="${end}">
              <c:if test="${page == requestScope.page}">
                  <li><span style="background-color: grey">${page}</span></li>
              </c:if>
              <c:if test="${page != requestScope.page}">
                  <li><a href="<c:url value="/book?method=findAll&page=${page}"/>"><span>${page}</span></a></li>
              </c:if>
          </c:forEach>
          <c:if test="${requestScope.page != requestScope.pages}">
              <li><a href="<c:url value="/book?method=findAll&page=${requestScope.page+1}"/>"><span>&raquo;</span></a></li>
          </c:if>
          <c:if test="${requestScope.page < requestScope.pages - 4}">
              <li><a href="<c:url value="/book?method=findAll&page=${requestScope.pages}"/> "><span>&raquo;&raquo;</span></a></li>
          </c:if>
          </c:if>
      </ul>
  </nav>

  <c:forEach items="${requestScope.bookList}" var="book">
      <div class="icon">
          <a href="<c:url value='/book?method=load&bid=${book.bid}'/>"><img src="<c:url value='${book.image}'/>" border="0"/></a>
          <br/>
          <a href="<c:url value='/book?method=load&bid=${book.bid}'/>">${book.bname}</a>
      </div>
  </c:forEach>


  
  </body>
 
</html>

