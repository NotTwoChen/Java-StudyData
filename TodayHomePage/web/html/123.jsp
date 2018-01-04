<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/3
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>不二云首页</title>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="../css/index_css.css">
</head>
<body onload="startTime()">
<div>
    <div id="navigationBar">
        <div>
            <a href="" class="floatLeft"><img id="logo" src="../img/logo.jpg"></a>
            <div class="floatLeft" style="font-size: large">首页</div>
            <div id="user" class="floatLeft">
                <%
                    session.setAttribute("name",null);
                    if (session.getAttribute("name") != null){
                %>
                <%=
                session.getAttribute("name")
                %>
                <%
                    }else {
                %>
                <a href="">登录</a>
                <span>丨</span>
                <a href="">注册</a>
                <%
                    }
                %>
            </div>
            <div class="floatRight">
                <div class="floatLeft">
                    <a href="">不二云首页</a>
                </div>
                <div class="floatLeft">丨</div>
                <div class="floatLeft">
                    <a href="">帮助与文档</a>
                </div>
                <div id="txt" class="floatLeft"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    //      $.get(
    //          "http://localhost:8080/TodayHomePage/login",
    //          function (data) {
    //              if (data){
    //                  $('#user').text(data);
    //              }
    //          }
    //      );
    function startTime() {
        var today = new Date()
        var date = today.toLocaleDateString();
        var time = today.toLocaleTimeString();
        document.getElementById('txt').innerHTML =date + " " + time
        setTimeout('startTime()', 500)
    }

</script>
</html>
