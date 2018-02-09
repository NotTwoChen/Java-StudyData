<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/24
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <input type="text" id="input" oninput="show()">
  </body>
<script type="text/javascript">
  function show() {
      var val = $("#input").val();
      $.ajax({
          url:  "/show",
          date: {"input":val},
          type: "GET",
          dateType: "json",
          async:  true,
          success: success,
          error: error,
          beforeSend: send,
          complete: final

      })
  }
  function success(allData) {
      $("#input~div").remove();
      $(allData).each(function (index,data) {
          $("#input").after($("<div>").text(data))
      })
  }
  function error() {
      alert("加载失败")
  }
  function send() {
      $("#input").after($("<h1>").text("正在加载"))
  }
  function final() {
      $("#input~h1").remove();
  }
</script>
</html>
