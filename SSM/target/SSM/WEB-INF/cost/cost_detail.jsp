<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/27
  Time: 10:53
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
    <jsp:param name="class" value="cost"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>资费ID：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.id}" /></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.name}"/></div>
        <div class="text_info clearfix"><span>资费状态：</span></div>
        <div class="input_info">
            <select class="readonly" disabled>
                <option <c:if test="${cost.status == 1}">selected="selected"</c:if>>暂停</option>
                <option <c:if test="${cost.status == 2}">selected="selected"</c:if>>开通</option>
                <option <c:if test="${cost.status == 3}">selected="selected"</c:if>>删除</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="radFeeType" <c:if test="${cost.costType == 3}">checked="checked"</c:if> id="monthly" disabled="disabled" />
            <label for="monthly">包月</label>
            <input type="radio" name="radFeeType" <c:if test="${cost.costType == 1}">checked="checked"</c:if> id="package" disabled="disabled" />
            <label for="package">套餐</label>
            <input type="radio" name="radFeeType" <c:if test="${cost.costType == 2}">checked="checked"</c:if> id="timeBased" disabled="disabled" />
            <label for="timeBased">计时</label>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.baseDuration}"  />
            <span>小时</span>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text"  class="readonly" readonly value="${cost.baseCost}" />
            <span>元</span>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text"  class="readonly" readonly value="${cost.unitCost}" />
            <span>元/小时</span>
        </div>
        <div class="text_info clearfix"><span>创建时间：</span></div>
        <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.creatime}"/>" /></div>
        <div class="text_info clearfix"><span>启动时间：</span></div>
        <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.startime}"/>" /></div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70 readonly" readonly>${cost.descr}</textarea>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='fee_list.html';" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
