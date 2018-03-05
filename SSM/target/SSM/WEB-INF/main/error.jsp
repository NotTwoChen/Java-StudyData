<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/5
  Time: 11:36
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
        var timer;
        //启动跳转的定时器
        function startTimes() {
            timer = window.setInterval(showSecondes,1000);
        }

        var i = 5;
        function showSecondes() {
            if (i > 0) {
                i--;
                document.getElementById("secondes").innerHTML = i;
            }
            else {
                window.clearInterval(timer);
                location.href = "../main(old)/login.html";
            }
        }

        //取消跳转
        function resetTimer() {
            if (timer != null && timer != undefined) {
                window.clearInterval(timer);
                location.href = "../main(old)/login.html";
            }
        }
    </script>
</head>
<body class="error_page" onload="startTimes();">
<h1 id="error">
    遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
    <a  href="javascript:resetTimer();">返回</a>
</h1>
</body>
</html>
