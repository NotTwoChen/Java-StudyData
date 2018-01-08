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
    <style type="text/css">
      #menu>button{
        width: 160px;
        height: 50px;
        margin-bottom: 10px;
        border: solid 1px grey;
        border-radius: 5px;
      }
      #manage>button{
        width: 50px;
        height: 50px;
        margin-bottom: 10px;
        border: solid 1px grey;
        border-radius: 5px;
        margin-right: 10px;
      }
      #books{
        float: left;
        width: 960px;
      }
    </style>
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
        <div id="menu" class="floatLeft" style="width: 160px;height: 900px;margin-top: 50px;">
          <button style="background-color: #3385ff" onclick="menuClick(this)" name="0">全部书籍</button>
          <button onclick="menuClick(this)" name="1">经济管理</button>
          <button onclick="menuClick(this)" name="2">成功励志</button>
          <button onclick="menuClick(this)" name="3">历史传记</button>
          <button onclick="menuClick(this)" name="4">两性情感</button>
          <button onclick="menuClick(this)" name="5">亲子少儿</button>
          <button onclick="menuClick(this)" name="6">文学艺术</button>
          <button onclick="menuClick(this)" name="7">社会科学</button>
          <button onclick="menuClick(this)" name="8">原创小说</button>
          <button onclick="menuClick(this)" name="9">科技开发</button>
          <button onclick="menuClick(this)" name="10">其他分类</button>

        </div>
        <div class="floatLeft" style="height: 50px;width: 960px">
          <div class="floatRight">
            <div id="manage">
              <button>
                <a href="" >管理书籍</a>
              </button>
              <a href="baidu.com">
                <button>账户设置</button>
              </a>

            </div>
          </div>
          <div class="floatRight" style="margin: 15px 25px">
              <input type="text" name="bookInfo" id="query" placeholder="查询书籍/作者">
              <button onclick="btnClick()" id="btn">查询</button>
          </div>

        </div>
        <div id="books"></div>


      </div>
    </div>
  </div>
  </body>
  <script type="text/javascript">

    function menuClick(tag) {
        var text = $(tag).text();
        var attr = $(tag).attr("name");
        console.log(attr);
        if (text === "全部书籍"){
            $('table').css({"display":"block"});
        }else{
            $('table').css({"display":"none"});
            $('table[name='+attr+']').css({"display":"block"});
            }
    }
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
                    $('#books').append(
                        $('<table>').append(
                            $('<tr>').append(
                                $('<td>').append(
                                    // TODO 书籍详情页的转换和得到
                                    $('<a>').append(
                                    $('<img>').attr("src",obj['cover'])
                                    )
                                        .attr("href","bookContent.jsp?bid="+obj['bid'])
                                ).css({"height":"200px","box-shadow":"0 5px 5px #b0b0b0","border-radius":"10px"})
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').text("《"+obj['bname']+"》").css({"text-aline":"left"})
                            )
                        ).append(
                            $('<tr>').append(
                                $('<td>').append(
                                    $('<span>').html(obj['author']).css({"font-size":"10px","float":"left"})
                                ).append(
                                    $('<span>').html("￥"+obj['price']).css({"font-size":"10px","float":"right","color":"red"})
                                )
                            )
                        ).attr({"id":"book"+obj['bid'],"border":1,"name":obj['cid']})
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
