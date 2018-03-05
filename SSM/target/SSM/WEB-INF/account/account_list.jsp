<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/27
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>云科技</title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //删除
        function deleteAccount(id) {
            var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
            if (r) {
                document.getElementById("operate_result_info").style.display = "block";
                window.location.href = "${pageContext.request.contextPath}/account/deleteAccount?account_id="+id
            }
        }
        function pause_account(id) {
            var r = window.confirm("确定要暂停此账务账号吗？");
            if (r){
                window.location.href = "${pageContext.request.contextPath}/account/pauseAccount?account_id="+id
            }
        }
        function start_account(id) {
            var r = window.confirm("确定要开通此账务账号吗？");
            if (r){
                window.location.href = "${pageContext.request.contextPath}/account/startAccount?account_id="+id
            }
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<jsp:include page="../include/header.jsp"/>
<!--Logo区域结束-->
<!--导航区域开始-->
<jsp:include page="../include/navi.jsp">
    <jsp:param name="class" value="account"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="${pageContext.request.contextPath}/account/account_list" method="post">
        <!--查询-->
        <div class="search_add">
            <div>身份证：<input type="text" name="idcardNo" class="text_search" value="${pageBean.idcardNo}" /></div>
            <div>姓名：<input type="text" name="realName" class="width70 text_search" value="${pageBean.realName}" /></div>
            <div>登录名：<input type="text" name="loginName" class="text_search" value="${pageBean.loginName}"/></div>
            <div>
                状态：
                <select class="select_search" name="status">
                    <option value="0" <c:if test="${pageBean.status == '0'}">selected="selected"</c:if>>全部</option>
                    <option value="1" <c:if test="${pageBean.status == '1'}">selected="selected"</c:if>>开通</option>
                    <option value="2" <c:if test="${pageBean.status == '2'}">selected="selected"</c:if>>暂停</option>
                    <option value="3" <c:if test="${pageBean.status == '3'}">selected="selected"</c:if>>删除</option>
                </select>
            </div>
            <div><input type="submit" value="搜索" class="btn_search" /></div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/account/toAddAccount';" />
        </div>
        <!--删除等的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功，且已删除其下属的业务账号！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>账号ID</th>
                    <th>姓名</th>
                    <th class="width150">身份证</th>
                    <th>登录名</th>
                    <th>状态</th>
                    <th class="width100">创建日期</th>
                    <th class="width150">上次登录时间</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="account">
                    <tr>
                        <td>${account.accountId}</td>
                        <td><a href="${pageContext.request.contextPath}/account/account_detail?account_id=${account.accountId}">${account.realName}</a></td>
                        <td>${account.idcardNo}</td>
                        <td>${account.loginName}</td>
                        <td>
                           <c:if test="${account.status == '1'}">开通</c:if>
                           <c:if test="${account.status == '2'}">暂停</c:if>
                           <c:if test="${account.status == '3'}">删除</c:if>
                        </td>
                        <td><fmt:formatDate value="${account.createDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${account.pauseDate}" pattern="yy-MM-dd hh:mm:ss"/></td>
                        <td class="td_modi">
                            <c:choose>
                                <c:when test="${account.status == '1'}">
                                    <input type="button" value="暂停" class="btn_pause" onclick="pause_account(${account.accountId});" />
                                </c:when>
                                <c:when test="${account.status == '2'}">
                                    <input type="button" value="开通" class="btn_start" onclick="start_account(${account.accountId});" />
                                </c:when>
                            </c:choose>
                            <c:if test="${account.status != '3'}">
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/account/toModiAccount?account_id=${account.accountId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.accountId});" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
        </div>
        <!--分页-->
        <jsp:include page="../include/pages.jsp">
            <jsp:param name="controller" value="/account/account_list"/>
            <jsp:param name="params" value="&idcardNo=${pageBean.idcardNo}&realName=${pageBean.realName}&loginName=${pageBean.loginName}&status=${pageBean.status}"/>
        </jsp:include>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
