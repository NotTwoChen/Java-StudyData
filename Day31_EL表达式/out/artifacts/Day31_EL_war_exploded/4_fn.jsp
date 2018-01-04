<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/4
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="wsh" uri="http://wsh.com" %>
<html>
<head>
    <title>EL函数库</title>
</head>
<body>
    <%--
        判断参数str是否以e结尾
    --%>
    ${fn:endsWith(param.str,"e")}
    ${wsh:reverse("abcdef")}
</body>
</html>
