<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/27
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>云科技</title>
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

        //显示修改密码的信息项
        function showPwd(chkObj) {
            if (chkObj.checked)
                document.getElementById("divPwds").style.display = "block";
            else
                document.getElementById("divPwds").style.display = "none";
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
    <!--保存成功或者失败的提示消息-->
    <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
    <form action="/account/account_modi" method="post" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info">
            <input type="text" name="accountId" value="${account.accountId}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" name="realName" value="${account.realName}" />
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">20长度以内的汉字、字母和数字的组合</div>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" name="idcardNo" value="${account.idcardNo}" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" name="loginName" value="${account.loginName}" readonly class="readonly"  />
            <!--
            <div class="change_pwd">
                <input id="chkModiPwd" type="checkbox" onclick="showPwd(this);" />
                <label for="chkModiPwd">修改密码</label>
            </div>
            -->
        </div>
        <!--修改密码部分-->
        <!--
        <div id="divPwds">
            <div class="text_info clearfix"><span>旧密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
            </div>
            <div class="text_info clearfix"><span>新密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
            </div>
            <div class="text_info clearfix"><span>重复新密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">两次密码必须相同</div>
            </div>
        </div>
        -->
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200" name="telephone" value="${account.telephone}"/>
            <span class="required">*</span>
            <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
        </div>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info">
            <input type="text" name="recommenderIdcardNo" value="${account.recommenderAccount.idcardNo}"/>
            <div class="validate_msg_long error_msgs">正确的身份证号码格式</div>
        </div>
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input type="text" name="birthdate" value="<fmt:formatDate value="${account.birthdate}"/>" readonly class="readonly" />
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width200" name="email" value="${account.email}"/>
            <div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">
            <select name="occupation">
                <option <c:if test="${account.occupation == '大学生'}">selected="selected"</c:if>>大学生</option>
                <option <c:if test="${account.occupation == '程序员'}">selected="selected"</c:if>>程序员</option>
                <option <c:if test="${account.occupation == '工程师'}">selected="selected"</c:if>>工程师</option>
                <option <c:if test="${account.occupation == '科学家'}">selected="selected"</c:if>>科学家</option>
                <option <c:if test="${account.occupation == '其他'}">selected="selected"</c:if>>其他</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="gender" value="女" <c:if test="${account.gender == '女'}">checked="checked"</c:if> id="female" onclick="feeTypeChange(1);" />
            <label for="female">女</label>
            <input type="radio" name="gender" value="男" <c:if test="${account.gender == '男'}">checked="checked"</c:if> id="male" onclick="feeTypeChange(2);" />
            <label for="male">男</label>
        </div>
        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info">
            <input type="text" class="width350" name="emailaddress" value="${account.emailaddress}"/>
            <div class="validate_msg_tiny">50长度以内</div>
        </div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info">
            <input type="text" name="zipcode" value="${account.zipcode}"/>
            <div class="validate_msg_long">6位数字</div>
        </div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info">
            <input type="text" name="qq" value="${account.qq}"/>
            <div class="validate_msg_long">5到13位数字</div>
        </div>
        <!--操作按钮-->
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
