<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/15
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1>SUCCESS!~</h1>
    <c:forEach items="${requestScope.users}" var="user">
        <h5>${user.username}--${user.age}</h5>
    </c:forEach>

</body>
</html>
