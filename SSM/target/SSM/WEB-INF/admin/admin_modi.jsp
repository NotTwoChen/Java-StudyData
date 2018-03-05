<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/3
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<jsp:include page="../include/header.jsp"/>
<!--Logo区域结束-->
<!--导航区域开始-->
<jsp:include page="../include/navi.jsp">
    <jsp:param name="class" value="admin"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <div id="save_result_info" class="save_success">保存成功！</div>
    <form action="${pageContext.request.contextPath}/admin/admin_modi" method="post" class="main_form">
        <input type="hidden" name="adminId" value="${adminInfo.adminId}">
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" name="name" value="${adminInfo.name}" />
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
        </div>
        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="adminCode" value="${adminInfo.adminCode}"  /></div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" name="telephone" value="${adminInfo.telephone}"  />
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width200" name="email" value="${adminInfo.email}"/>
            <span class="required">*</span>
            <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
        </div>
        <div class="text_info clearfix"><span>角色：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <c:forEach items="${roleInfos}" var="role">
                    <li><input type="checkbox" <c:forEach items="${adminInfo.roleInfos}" var="adminRole"><c:if test="${adminRole.roleId == role.roleId}">checked</c:if></c:forEach> name="roleIds" value="${role.roleId}"/>${role.name}</li>
                    </c:forEach>
                </ul>
            </div>
            <span class="required">*</span>
            <div class="validate_msg_tiny error_msg">至少选择一个</div>
        </div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
            <input type="button" value="取消" class="btn_save" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
