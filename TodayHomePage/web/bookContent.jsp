<%@ page import="com.wsh.project.util.JdbcUtil" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.wsh.project.dao.BookDao" %>
<%@ page import="com.wsh.project.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/3
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍简介</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        #navigationBar{
            background-color: #ffffff;
            height: 70px
        }
        #menuBar{
            background-color: #f5f8fa;
            height: 900px
        }
        #navigationBar>div{
            margin: 0px auto;
            width: 1181px
        }
        .floatLeft{
            float: left;
        }
        .floatRight{
            float: right;
        }
        #logo{
            height: 70px
        }
        #navigationBar>div>div{
            height: 54px;
            margin-top: auto;
            padding-top: 25px
        }
        #navigationBar>div>div>div>a{
            text-decoration-line: none;
            color: #4477d0
        }
        #txt{
            color: #4477d0;
            font-size: 17px;
            margin-left: 20px
        }
        #user{
            color: red;
            height: 54px;
            margin-top: auto;
            margin-left: 330px ;
            padding-top: 25px;
            font-size: large
        }
        #user>a{
            text-decoration: none;
            color: red;
            font-size: 15px;
        }
        table{
            text-align: center;
            display: block;
            float: left;
        }
        #bookList{
            width: 1120px;
            height: 900px;
            margin:0 auto;
            background-color: #d8d7d2
        }
    </style>
</head>
<body onload="startTime()">
<div>
    <div id="navigationBar">
        <div>
            <a href="" class="floatLeft"><img id="logo" src="img/logo.jpg"></a>
            <div class="floatLeft" style="font-size: large">首页</div>
            <div id="user" class="floatLeft">
                <%
                    if (session.getAttribute("name") != null){
                %>
                <a href="">用户:<%=session.getAttribute("name")%></a>
                <span>丨</span>
                <a href="login.html" onclick="exit()">退出</a>
                <%
                }else {
                %>
                <a href="login.html">登录</a>
                <span>丨</span>
                <a href="register.html">注册</a>
                <%
                    }
                %>
            </div>
            <div class="floatRight">
                <div class="floatLeft">
                    <a href="index.jsp">不二云首页</a>
                </div>
                <div class="floatLeft">丨</div>
                <div class="floatLeft">
                    <a href="">帮助与文档</a>
                </div>
                <div id="txt" class="floatLeft"></div>
            </div>
        </div>
    </div>
    <div id="menuBar">
        <div id="bookList">
            <%
                Book bid = new BookDao().query(Integer.decode(request.getParameter("bid")));
            %>

        </div>
    </div>

</div>
</body>
</body>
<script type="text/javascript">
    $.post(
        "book",{"bid":<%=request.getParameter("bid")%>},
        function (data,status) {
            if (status === "success") {
                if (data) {
                    var obj = JSON.parse(data);
                    $('table').remove();
                    if (!obj['cover']) {
                        obj['cover'] = "img/此书暂无封面.jpg"
                    }
                    if (!obj['content']) {
                        obj['content'] = "《"+obj['bname']+"》暂无简介"
                    }
                    $('#bookList').append(
                        $('<table>').append(
                            $('<tr>').append(
                                $('<td>').append(
                                    $('<img>').attr("src", obj['cover'])
                                )
                            ).append(
                                $('<td>').append(
                                    $('<td>').text("简介:" + obj['content'])
                                )
                            )
                        ).attr("border", 1)
                    )
                }
            }
        }
    )
</script>
</html>
