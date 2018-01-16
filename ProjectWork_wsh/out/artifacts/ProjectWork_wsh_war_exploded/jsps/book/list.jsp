<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
      <script src="../../../NotTwoCloud/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
    img{
        height: 150px;
    }
    ul{
        width: 820px;
        float: left;
    }
    li{
        float: left;
        list-style: none;
        padding: 2px;
    }
    li>form{
        margin-top: 4px;
    }
    li>form>input{
        width: 45px;
    }
    i{
        margin-right: 5px;
    }
    a{
        text-decoration-line: none;
        color: red;
    }
    span{
        text-align: center;
        line-height: 34px;
        width: 34px;
        height: 34px;
        border: solid 1px grey;
        border-radius: 5px;
        cursor:pointer;
        display: block;
    }
    span:hover{
        background-color: grey;
    }
</style>
  </head>
  <body>
  <nav><ul></ul></nav>
  </body>
  <script type="text/javascript">
      $.get(
          "/NotTwoCloud/book?method=query&pageCode=${param.pageCode}&cid=${param.cid}",
          function (data, status) {
              if (status === "success" && data){
                  var bookList = data['list'];
                  $.each(bookList,function (index, obj) {
                      $('body').append(
                          $('<div>').append(
                              $('<a>').append(
                                  $('<img>').attr({"src":"../../"+obj['image'],"border":"1"})
                              ).attr("href","/NotTwoCloud/book?method=load&bid="+obj['bid'])
                          ).append(
                              $('<br>')
                          ).append(
                              $('<a>').text(obj['bname']).attr("href","/NotTwoCloud/book?method=load&bid="+obj['bid'])
                          ).attr("class","icon")
                      )
                  });
                  var p = data['pageCode'];
                  var sp = data['startPage'];
                  var ep = data['endPage'];
                  var tp = data['totalPage'];
                  var page = new Array(5);
                  if (p < 3 && tp <= 5){page.splice(0,page.length)
                      for (var i = sp; i <= tp ; i++){page.push(i);}}
                  if (p < 3 && tp > 5){page = [sp,sp+1,sp+2,ep-1,ep];}
                  if (p >= 3 && p + 2 < tp){page = [sp,sp+1,sp+2,ep-1,ep];}
                  if (p + 2 >= tp && tp > 3){page.splice(0,page.length)
                      for (var i = sp; i <= tp ; i++){page.push(i);}}
                  if (p > 3) {addPage("首页",1);}
                  if (p > 1){addPage("上一页",${param.pageCode-1});}
                  var pageCode = ${param.pageCode}
                  $.each(page,function (index,obj) {
                      if (pageCode === obj){
                          $('ul').append($('<li>').append($('<span>').text(obj).css("backgroundColor","grey")))
                      }else {
                          $('ul').append($('<li>').append($('<a>').append($('<span>').text(obj)).attr("href","/NotTwoCloud/jsps/book/list.jsp?pageCode="+obj+"&cid=${param.cid}")))
                      }
                  });
                  if (p !== tp){addPage("下一页",${param.pageCode+1})}
                  if (p < tp-2){addPage("末页",tp)}
                  $('ul').append(
                      $('<li>').append(
                          $('<form>').append(
                              $('<input>').attr({"type":"hidden","name":"cid","value":${param.cid}})
                          ).append(
                              $('<input>').attr({"type":"text","name":"pageCode"})
                          ).append(
                              $('<i>').text("/"+data['totalPage'])
                          ).append(
                              $('<input>').attr({"type":"submit","value":"跳转"})
                          ).attr({"action":"/NotTwoCloud/jsps/book/list.jsp"})
                      )
                  )
              }
          }
      );
      function addPage(a,b) {
          $('ul').append(
              $('<li>').append(
                  $('<a>').append(
                      $('<span>').text(a).css("width","68px")
                  ).attr("href","/NotTwoCloud/jsps/book/list.jsp?pageCode="+b+"&cid=${param.cid}")
              )
          )
      };
  </script>
 
</html>

