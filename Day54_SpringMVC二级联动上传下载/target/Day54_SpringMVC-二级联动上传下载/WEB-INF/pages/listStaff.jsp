<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<select name="" id="depart" title="" onchange="changePost()">
    <option value="-1">---请选择---</option>
    <option value="0">---七曜狱---</option>
    <option value="1">---金乌塔---</option>
    <option value="2">---紫羽殿---</option>
    <option value="3">---无妄府---</option>
</select>
<select name="" id="post" title="">
    <option value="-1">---请选择---</option>
</select>
</body>
<script type="text/javascript">
    function changePost() {
        var value = document.getElementById("depart").value;
        $.post(
            "/user/listStaff?id="+value,
            function (data,status) {
                var select = document.getElementById("post");
                select.innerHTML = "<option value='-1'>---请选择---</option>";
                $.each(data,function (index,post) {
                    select.innerHTML += "<option value="+post['id']+">---"+post['name']+"---</option>";
                })
            }
        )
    }
</script>
</html>
