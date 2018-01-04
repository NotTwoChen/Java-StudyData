<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/3
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>
    <%
        // 代理域
        // 使用PageContext,可以向其他域对象中
        // 设置属性
        // 给request域设置域属性
        pageContext.setAttribute(
                "game","Page",pageContext.PAGE_SCOPE
        );pageContext.setAttribute(
                "game","Request",pageContext.REQUEST_SCOPE
        );pageContext.setAttribute(
                "game","Session",pageContext.SESSION_SCOPE
        );pageContext.setAttribute(
                "game","Application",pageContext.APPLICATION_SCOPE
        );
        // 全域查找
        // 这里就会去pageContext域中找属性名为game的属性
//        Object game = pageContext.getAttribute("game",pageContext.REQUEST_SCOPE);
        Object game1 = pageContext.findAttribute("game");
        out.write(game1.toString());
    %>
</body>
</html>
