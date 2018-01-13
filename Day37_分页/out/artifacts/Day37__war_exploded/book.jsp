<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/13
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍信息</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="" method="get">
    <input type="hidden" name="pageCode" value="1">
    书名:<input type="text" name="bookName"><br>
    作者:<input type="text" name="author"><br>
    价格:<input type="text" name="price"><br>
    类型:<input type="text" name="category"><br>
    <button type="button">查询</button>
</form>
    <div id="bookList">
    </div>
</body>
<script type="text/javascript">
    $('button').click(function () {
        $.get(
            "/show"
            +"?pageCode="+$("input[name='pageCode']").val()
            +"&bookName="+$("input[name='bookName']").val()
            +"&author="+$("input[name='author']").val()
            +"&price="+$("input[name='price']").val()
            +"&category="+$("input[name='category']").val(),
            function (data,state) {
                if (state === "success" && data){
                    console.log(data);
                    var book = data['bookList'];
                    $('<table>').remove();
                    $('#bookList').append(
                        $('<table>').attr("border","1").append(
                            $('<tr>').append(
                                $('<td>').text("书名")
                            ).append(
                                $('<td>').text("作者")
                            ).append(
                                $('<td>').text("价格")
                            ).append(
                                $('<td>').text("类型")
                            )
                        ));
                    $.each(book,function (index, obj) {
                        console.log(index);
                        console.log(obj);
                        $('table').attr("border","1").append(
                            $('<tr>').append(
                                $('<td>').text(obj['bookName'])
                            ).append(
                                $('<td>').text(obj['author'])
                            ).append(
                                $('<td>').text(obj['price'])
                            ).append(
                                $('<td>').text(obj['category'])
                            )
                        )
                    });
                }
            }
        );
    });

</script>
</html>
