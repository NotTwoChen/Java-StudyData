<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/5
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<ul id="menu">
    <c:choose>
        <c:when test="${currentModule == 0}">
            <li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>
        </c:when>
        <c:otherwise>
            <li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_off"></a></li>
        </c:otherwise>
    </c:choose>
    <c:forEach items="${allModules}" var="module">
        <c:if test="${module.moduleId == 1}">
            <c:choose>
                <c:when test="${currentModule == 1}">
                    <li><a href="${pageContext.request.contextPath}/role/role_list" class="role_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/role/role_list" class="role_off"></a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${module.moduleId == 2}">
            <c:choose>
                <c:when test="${currentModule == 2}">
                    <li><a href="${pageContext.request.contextPath}/admin/admin_list" class="admin_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/admin/admin_list" class="admin_off"></a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${module.moduleId == 3}">
            <c:choose>
                <c:when test="${currentModule == 3}">
                    <li><a href="${pageContext.request.contextPath}/cost/cost_list" class="fee_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/cost/cost_list" class="fee_off"></a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${module.moduleId == 4}">
            <c:choose>
                <c:when test="${currentModule == 4}">
                    <li><a href="${pageContext.request.contextPath}/account/account_list" class="account_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/account/account_list" class="account_off"></a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${module.moduleId == 5}">
            <c:choose>
                <c:when test="${currentModule == 5}">
                    <li><a href="${pageContext.request.contextPath}/service/service_list" class="service_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/service/service_list" class="service_off"></a></li>
                </c:otherwise>
            </c:choose>
        </c:if>
    </c:forEach>
    <%--<li><a href="bill/bill_list.html" class="bill_off"></a></li>--%>
    <%--<li><a href="report/report_list.html" class="report_off"></a></li>--%>
    <%--<li><a href="user/user_info.html" class="information_off"></a></li>--%>
    <%--<li><a href="user/user_modi_pwd.html" class="password_off"></a></li>--%>
</ul>
