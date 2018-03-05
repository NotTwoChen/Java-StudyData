<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/1
  Time: 9:12
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
    <div id="save_result_info" class="save_fail">资费修改失败！数据并发错误。</div>
    <form action="${pageContext.request.contextPath}/service/service_modi" method="post" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>业务账号ID：</span></div>
        <div class="input_info">
            <input type="text" name="serviceId" value="${service.serviceId}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>OS 账号：</span></div>
        <div class="input_info">
            <input type="text" name="osUsername" value="${service.osUsername}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info">
            <input type="text" name="unixHost" value="${service.unixHost}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info">
            <select class="width150" name="costId">
                <c:forEach items="${costs}" var="cost">
                    <option value="${cost.id}" <c:if test="${service.costId == cost.id}">selected="selected"</c:if>>${cost.name}</option>
                </c:forEach>
            </select>
            <div class="validate_msg_long">请修改资费类型，或者取消修改操作。</div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
            <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/service_list';"/>
        </div>


        <p>业务说明：<br />
            1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
            2、提交操作到消息队列；<br />
            3、每月月底由程序自动完成业务所关联的资费；</p>

    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
