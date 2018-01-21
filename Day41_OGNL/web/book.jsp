<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/17
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示图书</title>
</head>
<body>

<s:if test="#books != null">
    <table border="1">
        <s:iterator var="book" value="#books">
            <tr>
                <td>
                    <s:property value="#book.name"/>
                </td>
                <td>
                    <s:property value="#book.author"/>
                </td>
                <td>
                    <s:property value="#book.category"/>
                </td>
                <%--<td>${book.name}</td>--%>
                <%--<td>${book.author}</td>--%>
                <%--<td>${book.category}</td>--%>
            </tr>
        </s:iterator>
    </table>
</s:if>
</body>
</html>
