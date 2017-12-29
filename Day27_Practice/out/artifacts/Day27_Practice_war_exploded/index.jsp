<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2017/12/28
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Query</title>
    <script src="js/jquery-3.2.1.min.js"></script>

</head>
<body>
<form action="Insert" method="post">
    <label for="username">username</label>
    <input type="text" id="username" name="username">
    <label for="password">password</label>
    <input type="text" id="password" name="password">
    <label for="name">name</label>
    <input type="text" id="name" name="name">
    <input type="submit">
</form>
  <button id="btn">
      查询数据
  </button>

</body>
<script type="text/javascript">
    $('#btn').click(function () {
        window.location="userdata.html"
    })
</script>
</html>
