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
        //显示选填的信息项
        function showOptionalInfo(imgObj) {
            var div = document.getElementById("optionalInfo");
            if (div.className === "hide") {
                div.className = "show";
                imgObj.src = "../images/hide.png";
            }
            else {
                div.className = "hide";
                imgObj.src = "../images/show.png";
            }
            var idcardNo = document.getElementById("idcardNo").value;
            var birthday = idcardNo.substring(6,10) + "-" + idcardNo.substring(10,12) + "-" + idcardNo.substring(12,14);
            document.getElementById("birthdate").value = birthday;
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
    <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
    <form action="${pageContext.request.contextPath}/account/account_add" method="post" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" name="realName" value="" placeholder="张三"/>
            <span class="required">*</span>
            <div class="validate_msg_long">20长度以内的汉字、字母和数字的组合</div>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" name="idcardNo" value="" placeholder="422324......" id="idcardNo"/>
            <span class="required">*</span>
            <div class="validate_msg_long">正确的身份证号码格式</div>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" name="loginName" value="" placeholder="创建即启用，状态为开通"/>
            <span class="required">*</span>
            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input type="password" name="loginPasswd" value="" placeholder="******"/>
            <span class="required">*</span>
            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" value="" placeholder="******"/>
            <span class="required">*</span>
            <div class="validate_msg_long">两次密码必须相同</div>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" name="telephone" value="" class="width200" placeholder="186......"/>
            <span class="required">*</span>
            <div class="validate_msg_medium">正确的电话号码格式：手机或固话</div>
        </div>
        <!--可选项-->
        <div class="text_info clearfix"><span>可选项：</span></div>
        <div class="input_info">
            <img src="../images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
        </div>
        <div id="optionalInfo" class="hide">
            <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
            <div class="input_info">
                <input type="text" name="recommender_IdcardNo" value="" placeholder="422324......"/>
                <div class="validate_msg_long">正确的身份证号码格式</div>
            </div>
            <div class="text_info clearfix"><span>生日：</span></div>
            <div class="input_info">
                <input type="date" name="birthdate" value="" readonly class="readonly" id="birthdate"/>
            </div>
            <div class="text_info clearfix"><span>Email：</span></div>
            <div class="input_info">
                <input type="text" name="email" value="" class="width350" placeholder="abc123..@xx.com"/>
                <div class="validate_msg_tiny">50长度以内，合法的 Email 格式</div>
            </div>
            <div class="text_info clearfix"><span>职业：</span></div>
            <div class="input_info">
                <select name="occupation">
                    <option value="">---请选择---</option>
                    <option>大学生</option>
                    <option>程序员</option>
                    <option>工程师</option>
                    <option>科学家</option>
                    <option>其他</option>
                </select>
            </div>
            <div class="text_info clearfix"><span>性别：</span></div>
            <div class="input_info fee_type">
                <input type="radio" name="gender" id="female" value="女" />
                <label for="female">女</label>
                <input type="radio" name="gender" checked="checked" id="male" value="男" />
                <label for="male">男</label>
            </div>
            <div class="text_info clearfix"><span>通信地址：</span></div>
            <div class="input_info">
                <input type="text" name="emailaddress" value="" class="width350" placeholder="上海市张江高科技园......"/>
                <div class="validate_msg_tiny">50长度以内</div>
            </div>
            <div class="text_info clearfix"><span>邮编：</span></div>
            <div class="input_info">
                <input type="text" name="zipcode" value="" placeholder="123456"/>
                <div class="validate_msg_long">6位数字</div>
            </div>
            <div class="text_info clearfix"><span>QQ：</span></div>
            <div class="input_info">
                <input type="text" name="qq" value="" placeholder="123456789"/>
                <div class="validate_msg_long">5到13位数字</div>
            </div>
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
