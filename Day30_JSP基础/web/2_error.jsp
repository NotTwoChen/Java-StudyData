<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/3
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--指定当前页面为错误处理页面--%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
    <%--
        JSP错误处理页面:
                可以指定当前页面为错误处理页面
                那么其他的JSP可以设置,当出现异常时
                要转发到哪个错误处理页面
                可以在错误处理页面使用内置对象exception
    --%>
    <%=
        exception.getMessage()
    %>
    <img src="img/pic.jpg" alt="错误页面">
</body>
</html>
