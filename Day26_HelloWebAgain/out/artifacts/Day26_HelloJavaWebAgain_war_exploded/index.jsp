<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2017/12/27
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>数据库</title>
  </head>
  <body onload="startTime()">
  <h1 style="color: red;margin-left: 650px;margin-top: 200px">
    不二极端编程数据库已经开启完毕!
  </h1>
  <h2 style="color: red;margin-left: 650px">Created by IntelliJ IDEA.</h2>
  <h2 style="color: red;margin-left: 650px">User: 陈不二</h2>
  <h2 style="color: red;margin-left: 650px" id="date"></h2>
  <h2 style="color: red;margin-left: 650px" id="time"></h2>
  <h2 style="color: red;margin-left: 650px">To change this template use File | Settings | File Templates.</h2>
  </body>
  <script type="text/javascript">
    function startTime() {
        var dates = new Date();
        var date = dates.toLocaleDateString();
        var time = dates.toTimeString();
        document.getElementById('date').innerHTML = "Date:" + date;
        document.getElementById("time").innerHTML = "Time:" + time;
        t = setTimeout('startTime()',500);
    }
  </script>
</html>
