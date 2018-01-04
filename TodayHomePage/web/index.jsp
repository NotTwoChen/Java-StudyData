<%@ page import="net.sf.json.JSONArray" %><%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2017/12/29
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>不二云首页</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="css/index_css.css">
  </head>
  <body onload="startTime()" onkeypress="btnClick()">
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
                request.getRequestDispatcher("login.html").forward(request,response);
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
    <div id="menuBar">

      <div id="bookList">
        <div style="height: 50px">
          <div class="floatLeft">
            <%--<form action="bookQuery" method="get">--%>
              <input type="text" name="bookInfo" id="query" placeholder="查询书籍/作者">
              <button onclick="btnClick()" id="btn">查询</button>
              <%--<input type="submit" value="查询">--%>
            <%--</form>--%>
          </div>
          <div class="floatRight">管理书籍</div>
        </div>

      </div>
    </div>
  </div>
  </body>
  <script type="text/javascript">

    function btnClick() {
        var bookInfo = $('#query').val();
        $.post(
            "query",{"bookInfo":bookInfo},
            function (data,status) {
                if (status === "success" && data){
                    var parse = JSON.parse(data);
                    $('table').css({"display":"none"});
                    $.each(parse,function (index, obj) {
                        var bid = obj['bid'];
                        $('#book'+bid).css({"display":"block"});
                    })
                }

            }
        )
    }



    $.getJSON(
        "book",
        function (data) {
            if (data !== null) {
                $('table').remove();
                $.each(data,function (index,obj) {
                    if (!obj['author']) {
                        obj['author'] = "佚名"
                    }
                    if (!obj['cover']) {
                        obj['cover'] = "img/此书暂无封面.jpg"
                    }
                    if (!obj['price']) {
                        obj['price'] = "此书暂未上架!"
                    }
                    $('#bookList').append(
                        $('<table>').append(
                            $('<tr>').append(
                                $('<td>').append(
                                    $('<a>').append(
                                    $('<img>').attr("src",obj['cover'])
                                    ).attr("href","bookContent.jsp?bid="+obj['bid'])
                                ).css("height","200px")
                            )
                        ).attr("border",1).append(
                            $('<tr>').append(
                                $('<td>').text("书号:"+obj['bid'])
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("书名:《"+obj['bname']+"》")
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("作者:"+obj['author'])
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("价钱:￥"+obj['price'])
                            )
                        ).attr("id","book"+obj['bid'])
                    )

                });
            }
        }
    );
    function exit() {
        $.get(
            "login",
            function () {
            }
        );
    }
      function startTime() {
          var today = new Date()
          var date = today.toLocaleDateString();
          var time = today.toLocaleTimeString();
          document.getElementById('txt').innerHTML =date + " " + time
          setTimeout('startTime()', 500)
      }

  </script>
</html>
