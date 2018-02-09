<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/30
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第${requestScope.pageBean.nowPageIndex}/${requestScope.pageBean.pageCount}页</span>
            <span>
				<s:if test="%{#request.pageBean.startPageIndex > 1}">
					<a href="<s:url action="%{#action}">
					<s:param name="nowPageIndex" value="1"/></s:url> ">[首页]</a>
                </s:if>
				<s:if test="%{#request.pageBean.nowPageIndex != 1}">
					<a href="<s:url action="%{#action}">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex-1}"/></s:url> ">[上一页]</a>
                </s:if>
				<s:iterator  begin="%{#request.pageBean.startPageIndex}" end="%{#request.pageBean.endPageIndex}" var="page">
                    <s:if test="%{#request.pageBean.nowPageIndex == #page}">
                        ${page}
                    </s:if>
                    <s:else>
						<a href="<s:url action="%{#action}">
					<s:param name="nowPageIndex" value="#page"/></s:url> ">[${page}]</a>
                    </s:else>
                </s:iterator>
				<s:if test="%{#request.pageBean.nowPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="%{#action}">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex+1}"/></s:url> ">[下一页]</a>
                </s:if>
				<s:if test="%{#request.pageBean.endPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="%{#action}">
					<s:param name="nowPageIndex" value="%{#request.pageBean.pageCount}"/></s:url> ">[尾页]</a>
                </s:if>
        </span>
        </td>
    </tr>
</table>
</body>
</html>
