<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/5
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>上传页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">

    <input type="file" name="items_pic">
    <input type="submit">
</form>
</body>
</html>
