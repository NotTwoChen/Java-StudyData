<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/28
  Time: 19:42
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
        //保存成功的提示信息
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

        //自动查询账务账号
        function searchAccounts() {
            var value = document.getElementById("idcardNo").value;
            $.post(
                "${pageContext.request.contextPath}/service/findAccount?idcardNo="+value,
                function (data) {
                    document.getElementById("accountId").value = data.accountId;
                }
            )
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
    <!--保存操作的提示信息-->
    <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
    <form action="${pageContext.request.contextPath}/service/service_add" method="post" class="main_form">
        <!--内容项-->
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" id="idcardNo" value="" placeholder="根据身份证号查询账务账号" class="width180" />
            <input type="button" value="查询账务账号" class="btn_search_large" onclick="searchAccounts()"/>
            <span class="required">*</span>
            <div class="validate_msg_short">没有此身份证号，请重新录入。</div>
        </div>
        <div class="text_info clearfix"><span>账务账号：</span></div>
        <div class="input_info">
            <input type="text" id="accountId" name="accountId" value="" />
            <span class="required">*</span>
            <div class="validate_msg_long">没有此账务账号，请重新录入。</div>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info">
            <select name="costId" title="">
                <option value="">---请选择---</option>
                <c:forEach items="${costs}" var="cost">
                    <option value="${cost.id}">${cost.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info">
            <input type="text" name="unixHost" value="" placeholder="***.***.***.***"  />
            <span class="required">*</span>
            <div class="validate_msg_long">15 长度，符合IP的地址规范</div>
        </div>
        <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
        <div class="input_info">
            <input type="text" name="osUsername" value="" placeholder="创建即启用，状态为开通"  />
            <span class="required">*</span>
            <div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input type="password" name="loginPasswd" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password"/>
            <span class="required">*</span>
            <div class="validate_msg_long">两次密码必须相同</div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
            <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/service_list';"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
