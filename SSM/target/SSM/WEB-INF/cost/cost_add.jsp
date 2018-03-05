<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/26
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //保存结果的提示
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

        //切换资费类型
        function feeTypeChange(type) {
            var inputArray = document.getElementById("main").getElementsByTagName("input");
            if (type == 1) {
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = true;
                inputArray[6].className += " readonly";
                inputArray[6].value = "";
            }
            else if (type == 2) {
                inputArray[4].readOnly = false;
                inputArray[4].className = "width100";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
            }
            else if (type == 3) {
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = true;
                inputArray[5].value = "";
                inputArray[5].className += " readonly";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
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
    <jsp:param name="class" value="cost"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
    <form action="${pageContext.request.contextPath}/cost/addCost" method="post" class="main_form">
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info">
            <input type="text" class="width300" name="name" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="radFeeType" id="monthly" onclick="feeTypeChange(1);" />
            <label for="monthly">包月</label>
            <input type="radio" name="radFeeType" checked="checked" id="package" onclick="feeTypeChange(2);" />
            <label for="package">套餐</label>
            <input type="radio" name="radFeeType" id="timeBased" onclick="feeTypeChange(3);" />
            <label for="timeBased">计时</label>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" name="baseDuration" value="" class="width100" />
            <span class="info">小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long">1-600之间的整数</div>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text" name="baseCost" value="" class="width100" />
            <span class="info">元</span>
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text" name="unitCost" value="" class="width100" />
            <span class="info">元/小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
        </div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea name="descr" class="width300 height70"></textarea>
            <div class="validate_msg_short error_msg">100长度的字母、数字、汉字和下划线的组合</div>
        </div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save"  onclick="showResult();" />
            <input type="button" value="取消" class="btn_save" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
