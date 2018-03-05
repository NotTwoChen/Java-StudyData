<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/1
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
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
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>业务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${service.serviceId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${service.accountId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>客户姓名：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.realName}" /></div>
        <div class="text_info clearfix"><span>身份证号码：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.idcardNo}" /></div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info"><input type="text" value="${service.unixHost}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>OS 账号：</span></div>
        <div class="input_info"><input type="text" value="${service.osUsername}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select disabled>
                <option <c:if test="${service.status == '1'}">selected="selected"</c:if>>开通</option>
                <option <c:if test="${service.status == '2'}">selected="selected"</c:if>>暂停</option>
                <option <c:if test="${service.status == '3'}">selected="selected"</c:if>>删除</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>开通时间：</span></div>
        <div class="input_info"><input type="text" value="<fmt:formatDate value="${service.createDate}"/>" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>资费 ID：</span></div>
        <div class="input_info"><input type="text" value="${service.cost.id}" class="readonly" readonly /></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input type="text" value="${service.cost.name}" readonly class="width200 readonly" /></div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70 readonly" readonly>${service.cost.descr}</textarea>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/service_list';" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
