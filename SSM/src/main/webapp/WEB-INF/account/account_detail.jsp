<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/27
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>云科技</title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
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
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${account.accountId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info"><input type="text" value="${account.realName}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" value="${account.idcardNo}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" value="${account.loginName}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200 readonly" readonly value="${account.telephone}" />
        </div>
        <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.recommenderId}" /></div>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.recommenderAccount.idcardNo}" /></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select disabled>
                <option <c:if test="${account.status == '1'}">selected="selected"</c:if>>开通</option>
                <option <c:if test="${account.status == '2'}">selected="selected"</c:if>>暂停</option>
                <option <c:if test="${account.status == '3'}">selected="selected"</c:if>>删除</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="<c:choose><c:when test="${account.status=='1'}"><fmt:formatDate value="${account.createDate}"/></c:when><c:when test="${account.status=='2'}"><fmt:formatDate value="${account.pauseDate}"/></c:when><c:otherwise><fmt:formatDate value="${account.closeDate}"/></c:otherwise></c:choose>" /></div>

        <div class="text_info clearfix"><span>上次登录时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="<fmt:formatDate value="${account.lastLoginTime}"/>" /></div>
        <div class="text_info clearfix"><span>上次登录IP：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="<fmt:formatDate value="${account.lastLoginIp}"/>" /></div>
        <!--可选项数据-->
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input type="text" readonly class="readonly" value="<fmt:formatDate value="${account.birthdate}"/>" />
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width350 readonly" readonly value="${account.email}" />
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">
            <select disabled>
                <option value="" <c:if test="${account.occupation == null}">selected="selected"</c:if>>---请选择---</option>
                <option <c:if test="${account.occupation == '大学生'}">selected="selected"</c:if>>大学生</option>
                <option <c:if test="${account.occupation == '程序员'}">selected="selected"</c:if>>程序员</option>
                <option <c:if test="${account.occupation == '工程师'}">selected="selected"</c:if>>工程师</option>
                <option <c:if test="${account.occupation == '科学家'}">selected="selected"</c:if>>科学家</option>
                <option <c:if test="${account.occupation == '其他'}">selected="selected"</c:if>>其他</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="radSex" <c:if test="${account.gender == '女'}">checked="checked"</c:if> id="female" disabled />
            <label for="female">女</label>
            <input type="radio" name="radSex" <c:if test="${account.gender == '男'}">checked="checked"</c:if> id="male" disabled />
            <label for="male">男</label>
        </div>
        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info"><input type="text" class="width350 readonly" readonly value="${account.emailaddress}" /></div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${account.zipcode}" /></div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${account.qq}" /></div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='account_list.html';" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
