<%--
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
        <%--<table border="1" style="text-align: center">--%>
          <%--<img src="img/此书暂无封面.jpg" alt="">--%>
        <%--</table>--%>

      </div>
    </div>
  </div>
  </body>
  <script type="text/javascript">

    $.getJSON(
        "book",
        function (data) {
            if (data !== null) {
                $('table').remove();
                $.each(data,function (index,obj) {
                    if (obj['cover'] === null){
                        obj['cover'] = "img/此书暂无封面.jpg"
                    }
                    $('#bookList').append(
                        $('<table>').append(
                            $('<tr>').append(
                                $('<td>').append(
                                    $('<a>').append(
                                    $('<img>').attr("src",obj['cover'])
                                    ).attr("href","book?bid="+obj['bid'])
                                )
                            )
                        ).attr("border",1).append(
                            $('<tr>').append(
                                $('<td>').text("书号:"+obj['bid'])
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("书名:"+obj['bname'])
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("作者:"+obj['author'])
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("价钱:"+obj['price'])
                            )
                        )
                    )
                });
                $('table').attr("border",1);
            }
        }
    );


//    $('.book').mouseleave(function () {
//        $(".content").eq( $(this).index()).css("display","none")
//    });

//    console.log($('.book'));
//    $('.book').mouseenter(function () {
//        console.log("sss");
//        $(".content").eq( $(this).index()).css("dispaly","block")
//    });
//    $('.book').mouseleave(function () {
//        $(this).children("span").css({"display":"none"})
//    });

    //    $.getJSON(
//        "book",
//        function (data) {
//            if (data !== null) {
//                $('tr').remove();
//                $('table').append(
//                    $('<tr>').append(
//                        $('<td>').text("书号"))
//                        .append(
//                        $('<td>').text("书名"))
//                        .append(
//                        $('<td>').text("作者"))
//                        .append(
//                        $('<td>').text("价格"))
//                        .append(
//                        $('<td>').text("封面"))
//                );
//                $.each(data,function (index,obj) {
//                    $('table').append(
//                        $('<tr>').append(
//                            $('<td>').text(obj['bid']))
//                            .append(
//                                $('<td>').text(obj['bname']))
//                            .append(
//                                $('<td>').text(obj['author']))
//                            .append(
//                                $('<td>').text(obj['price']))
//                            .append(
//                                $('<td>').append(
//                                    $('<img>').attr("src",obj['cover'])
//                            )
//                        )
//                    )
//                })
//            }
//        }
//    );


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
