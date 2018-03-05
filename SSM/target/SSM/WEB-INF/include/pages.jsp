<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/28
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div id="pages">
    <c:if test="${pageBean.nowPageIndex > 1}">
        <a href="${pageContext.request.contextPath}<%=request.getParameter("controller")%>?nowPageIndex=1<%=request.getParameter("params")%>">首页</a>
    </c:if>
    <c:if test="${pageBean.nowPageIndex > pageBean.startPageIndex}">
        <a href="${pageContext.request.contextPath}<%=request.getParameter("controller")%>?nowPageIndex=${pageBean.nowPageIndex-1}<%=request.getParameter("params")%>">上一页</a>
    </c:if>
    <c:forEach begin="${pageBean.startPageIndex}" end="${pageBean.endPageIndex}" var="page">
        <c:choose>
            <c:when test="${pageBean.nowPageIndex == page}">
                <a href="#" class="current_page">${page}</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}<%=request.getParameter("controller")%>?nowPageIndex=${page}<%=request.getParameter("params")%>">${page}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${pageBean.nowPageIndex < pageBean.endPageIndex}">
        <a href="${pageContext.request.contextPath}<%=request.getParameter("controller")%>?nowPageIndex=${pageBean.nowPageIndex+1}<%=request.getParameter("params")%>">下一页</a>
    </c:if>
    <c:if test="${pageBean.nowPageIndex < pageBean.pageCount}">
        <a href="${pageContext.request.contextPath}<%=request.getParameter("controller")%>?nowPageIndex=${pageBean.pageCount}<%=request.getParameter("params")%>">末页</a>
    </c:if>
</div>
