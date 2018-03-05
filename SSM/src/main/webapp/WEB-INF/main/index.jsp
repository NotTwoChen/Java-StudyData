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
    <script  src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        #showTime{
            float: left;
            margin: 20% 43%;
            color: white;
            font-size: x-large;
        }
        #showAdmin{
            float: left;
            margin: -15% 40%;
            color: white;
            font-size: x-large;
        }
    </style>
</head>
<body class="index">
<span id="showTime"></span>
<span id="showAdmin">[${admin.name}],欢迎您!</span>
<!--导航区域开始-->
<div id="index_navi">
    <jsp:include page="../main/menu.jsp"/>
</div>
</body>
<script type="text/javascript">
    setInterval("document.all.showTime.innerText=new   Date().toLocaleString()",1000)
</script>
</html>
