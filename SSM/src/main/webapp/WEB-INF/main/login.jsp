<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/5
  Time: 10:55
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
        function check_login() {
            var admin_code = $("#admin_code").val();
            if (admin_code === "") {
                $("#admin_code_msg").text("请输入账号!");
                return;
            }
            var password = $("#password").val();
            if (password === "") {
                $("#paasword_msg").text("请输入密码!");
                return;
            }
            var code = $("#code").val();
            if (code === ""){
                $("#code_msg").text("请输入验证码!");
                return;
            }
            $.ajax({
                type: 'post',
                url:'${pageContext.request.contextPath}/login/login',
                data:{'adminCode':admin_code,'password':password,'code':code},
                success:function(data){
                    if (data.flag === 1) {
                        // 账号错误
                        $("#admin_code_msg").text("账号错误!");
                    }else if (data.flag === 2){
                        // 密码错误
                        $("#password_msg").text("密码错误!");
                    }else if (data.flag === 3){
                        // 验证码错误
                        $("#code_msg").text("验证码错误!");
                        change();
                    }else {
                        // 成功
                        location.href = "toIndex";
                    }
                }
            })
        }
        function set_msg(id, msg) {
            $("#"+id).text(msg);
        }
        function change() {
            $("#code_image").attr("src","createImage?date="+new Date().getTime());
        }
    </script>
        </head>
<body class="index">
<div class="login_box">
    <table>
        <tr>
            <td class="login_info">账号：</td>
            <td colspan="2"><input id="admin_code" type="text" class="width150" /></td>
            <td class="login_error_info">
                <span class="required" hidden>30长度的字母、数字和下划线</span>
                <span class="required" id="admin_code_msg"></span>
            </td>
        </tr>
        <tr>
            <td class="login_info">密码：</td>
            <td colspan="2"><input id="password" type="password" class="width150" /></td>
            <td>
                <span class="required" hidden>30长度的字母、数字和下划线</span>
                <span class="required" id="password_msg"></span>
            </td>
        </tr>
        <tr>
            <td class="login_info">验证码：</td>
            <td class="width70"><input  type="text" class="width70" id="code" onfocus="set_msg()" /></td>
            <td><img src="${pageContext.request.contextPath}/login/createImage" alt="验证码" title="点击更换" id="code_image" onclick="change()" /></td>
            <td><span class="required" id="code_msg"></span></td>
        </tr>
        <tr>
            <td></td>
            <td class="login_button" colspan="2">
                <a href="javascript:check_login();"><img src="../images/login_btn.png" alt=""/></a>
            </td>
            <td><span class="required" hidden>用户名或密码错误，请重试</span></td>
        </tr>
    </table>
</div>
</body>
</html>
