<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/27
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <span style="color: red;font-size: large;margin: 5%">用户:${admin.name}&nbsp&nbsp 职权:${admin.roleInfos[0].name}</span>
    <a href="${pageContext.request.contextPath}/login/toLogin">[退出]</a>
</div>
