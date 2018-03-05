<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/28
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
        //删除
        function deleteAccount(id) {
            var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
            if (r) {
                $("#operate_msg").text("删除成功!!!");
                $("#operate_result_info").show();
                window.location.href = "${pageContext.request.contextPath}/service/service_delete?service_id="+id;
            }
        }
        //开通或暂停
        function setState() {
            var r = window.confirm("确定要开通此业务账号吗？");
            document.getElementById("operate_result_info").style.display = "block";
        }
        function start_service(id) {
            var confirm = window.confirm("确定要开通此业务账号吗?");
            if (confirm) {
                $.post(
                    "${pageContext.request.contextPath}/service/startService?service_id="+id,
                    function (data) {
                        $("#operate_msg").text(data.message);
                        $("#operate_result_info").show();
                        setTimeout(function () {
                            if (data.success){
                                window.location.href = "${pageContext.request.contextPath}/service/service_list";
                            }else {
                                $("#operate_result_info").hide();
                            }
                        },1000);
                    }
                )
            }
        }
        function pause_service(id) {
            var confirm = window.confirm("确定要暂停此业务账号吗?");
            if (confirm) {
                $.post(
                    "${pageContext.request.contextPath}/service/pauseService?service_id="+id,
                    function (data) {
                        $("#operate_msg").text(data.message);
                        $("#operate_result_info").show();
                        setTimeout(function () {
                            if (data.success){
                                window.location.href = "${pageContext.request.contextPath}/service/service_list";
                            }else {
                                $("#operate_result_info").hide();
                            }
                        },1000);
                    }
                )
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
    <jsp:param name="class" value="service"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="${pageContext.request.contextPath}/service/service_list" method="post">
        <!--查询-->
        <div class="search_add">
            <div>OS 账号：<input type="text" name="osUsername" value="${pageBean.osUsername}" class="width100 text_search" /></div>
            <div>服务器 IP：<input type="text" name="unixHost" value="${pageBean.unixHost}" class="width100 text_search" /></div>
            <div>身份证：<input type="text" name="idcardNo" value="${pageBean.idcardNo}" class="text_search" /></div>
            <div>状态：
                <select class="select_search" name="status">
                    <option value="0" <c:if test="${pageBean.status == '0'}">selected="selected"</c:if>>全部</option>
                    <option value="1" <c:if test="${pageBean.status == '1'}">selected="selected"</c:if>>开通</option>
                    <option value="2" <c:if test="${pageBean.status == '2'}">selected="selected"</c:if>>暂停</option>
                    <option value="3" <c:if test="${pageBean.status == '3'}">selected="selected"</c:if>>删除</option>
                </select>
            </div>
            <div><input type="submit" value="搜索" class="btn_search" /></div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/service/toAddService';" />
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            <span id="operate_msg"></span>
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="width50">业务ID</th>
                    <th class="width70">账务账号ID</th>
                    <th class="width150">身份证</th>
                    <th class="width70">姓名</th>
                    <th>OS 账号</th>
                    <th class="width50">状态</th>
                    <th class="width100">服务器 IP</th>
                    <th class="width100">资费</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="service">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/service/service_detail?service_id=${service.serviceId}" title="查看明细">${service.serviceId}</a></td>
                        <td>${service.account.accountId}</td>
                        <td>${service.account.idcardNo}</td>
                        <td>${service.account.realName}</td>
                        <td>${service.osUsername}</td>
                        <td>
                            <c:if test="${service.status == '1'}">开通</c:if>
                            <c:if test="${service.status == '2'}">暂停</c:if>
                            <c:if test="${service.status == '3'}">删除</c:if>
                        </td>
                        <td>${service.unixHost}</td>
                        <td>
                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.cost.name}</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                ${service.cost.descr}
                            </div>
                        </td>
                        <td class="td_modi">
                            <c:if test="${service.status != 3}">
                                <c:choose>
                                    <c:when test="${service.status == 1}">
                                        <input type="button" value="暂停" class="btn_pause" onclick="pause_service(${service.serviceId});" />
                                    </c:when>
                                    <c:when test="${service.status == 2}">
                                        <input type="button" value="开通" class="btn_start" onclick="start_service(${service.serviceId});" />
                                    </c:when>
                                </c:choose>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/service/toModi?service_id=${service.serviceId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${service.serviceId});" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
        </div>
        <!--分页-->
        <jsp:include page="../include/pages.jsp">
            <jsp:param name="controller" value="/service/service_list"/>
            <jsp:param name="params" value="&osUsername=${pageBean.osUsername}&unixHost=${pageBean.unixHost}&idcardNo=${pageBean.idcardNo}&status=${pageBean.status}"/>
        </jsp:include>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
