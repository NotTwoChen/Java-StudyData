<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/12
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
      table{
        /*margin: 0 auto;*/
      }
      div{
        /*margin-left: 35%;*/
      }
      a{
        text-decoration-line: none;
      }
      form{
        display: inline-block;
      }
      input[type='text']{
        display: inline-block;
        width: 40px;
      }

    </style>
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
  <c:out value="${requestScope.pageBean.pageBean.pageCode}"/>
  <div id="bookList">
  </div>
  <div>
    <c:if test="${requestScope.pageBean.pageCode > 1}">
      <a href="<c:url value="/show?pageCode=${requestScope.pageBean.pageCode-1}${requestScope.pageBean.params}"/>"><span style="width: 68px">&laquo;上一页</span></a>
    </c:if>

  <c:set value="" var="begin"/>
  <c:set value="" var="end"/>
    <%--当前页为{1~5}且总页数为{1~10}时--%>
  <c:if test="${requestScope.pageBean.pageCode - 5 < 1 && requestScope.pageBean.totalPages <= 10}">
    <%--页码遍历初始值begin为1,结束值end为总页数的值--%>
    <c:set value="1" var="begin"/>
    <c:set value="${requestScope.pageBean.totalPages}" var="end"/>
    <%--该情况为当前页"不居中"页码且总页数小于10时，预期效果为→→[1] 2 [3][4][5] --%>
  </c:if>
    <%--当前页为{1~5}且总页数为{10~∞}时--%>
  <c:if test="${requestScope.pageBean.pageCode - 5 < 1 && requestScope.pageBean.totalPages > 10}">
    <%--页码遍历初始值begin为1,结束值end为10--%>
    <c:set value="1" var="begin"/>
    <c:set value="10" var="end"/>
    <%--该情况为当前页"不居中"页码且总页数大于10时,预期效果为→→[1][2][3] 4 [5][6][7][8][9][10]--%>
  </c:if>
    <%--当前页为{6~∞}且当前页+4(即末尾页码)小于总页数的值时--%>
  <c:if test="${requestScope.pageBean.pageCode > 5 && requestScope.pageBean.pageCode + 4 < requestScope.pageBean.totalPages}">
    <%--页码遍历初始值begin为当前页的值-5,结束值end为当前页的值+4--%>
    <c:set value="${requestScope.pageBean.pageCode - 5}" var="begin"/>
    <c:set value="${requestScope.pageBean.pageCode + 4}" var="end"/>
    <%--该情况为当前页"居中"于页码且总页数大于10且末尾页码的值小于总页数,预期效果为→→[3][4][5][6][7] 8 [9][10][11][12]--%>
  </c:if>
    <%--当前页的值+4大于等于总页数时（额外条件，总页数的值大于5）
    {额外条件添加是因为当当前页的值为{1~5}且总页数小于等于5的时候，该条件同样成立，会对初始值和结束值重新赋值}--%>
  <c:if test="${requestScope.pageBean.pageCode + 4 >= requestScope.pageBean.totalPages && requestScope.pageBean.totalPages > 5}">
    <%--页码遍历初始值begin为总页数的值-9，结束值end为总页数--%>
    <c:set value="${requestScope.pageBean.totalPages - 9}" var="begin"/>
    <c:set value="${requestScope.pageBean.totalPages}" var="end"/>
    <%--该情况为当前页"居中"于页码或者超过居中页码位置,即总页数为末尾页码的时候,预期效果为→→[6][7][8][9][10][11][12] 13 [14][15]--%>
  </c:if>
    <%--定义一个域属性totalPages,值为10--%>
    <%--<c:set var="totalPages" value="10"/>--%>
  <%--<c:if test="${requestScope.pageBean.totalPages < 10}">--%>
    <%--&lt;%&ndash;如果后端传过来的数据小于10,则把域属性totalPages的值更改&ndash;%&gt;--%>
    <%--<c:set value="${requestScope.pageBean.totalPages}" var="totalPages"/>--%>
  <%--</c:if>--%>
  <c:forEach var="pageCode" begin="${begin}" end="${end}">

    <a href="<c:url value="/show?pageCode=${pageCode}${requestScope.pageBean.params}"/>">
      <c:if test="${pageCode == requestScope.pageBean.pageCode}">
        ${pageCode}
      </c:if>
      <c:if test="${pageCode != requestScope.pageBean.pageCode}">
        [${pageCode}]
      </c:if>
    </a>
  </c:forEach>
    <c:if test="${requestScope.pageBean.pageCode != requestScope.pageBean.totalPages}">
      <a href="<c:url value="/show?pageCode=${requestScope.pageBean.pageCode+1}${requestScope.pageBean.params}"/>"><span style="width: 68px">下一页&raquo;</span></a>
    </c:if>
    <form action="<c:url value="/show${requestScope.pageBean.params}"/>" method="get">
      <input type="text" name="pageCode">/${requestScope.pageBean.totalPages}
      <input type="submit" value="跳转页面">
    </form>
  </div>
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
          )
      });
  </script>
  </body>
</html>
