<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/20
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工库</title>
    <style type="text/css">
        table{
            text-align: center;
        }
        .wwFormTable>tbody>tr{
            display: none;
        }
        .wwFormTable>tbody>tr:last-child{
            display: block;
        }
        form{
            margin: 0;
        }
    </style>
</head>
<body>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>部门</td>
            <td>入职</td>
            <td>住址</td>
            <td>电话</td>
            <td>编辑</td>
        </tr>
        <s:iterator value="#session.staffs" var="staff">
            <tr>
                <td><s:property value="#staff.sid"/></td>
                <td><s:property value="#staff.name"/></td>
                <td><s:property value="#staff.age"/></td>
                <td><s:property value="#staff.branch"/></td>
                <td><s:property value="#staff.hiredate"/></td>
                <td><s:property value="#staff.address"/></td>
                <td><s:property value="#staff.telephone"/></td>
                <td>
                <s:form action="staff">
                    <s:textfield value="%{#staff.sid}" name="staff.sid" type="hidden"/>
                    <s:textfield value="%{#staff.name}" name="staff.name" type="hidden"/>
                    <s:textfield value="%{#staff.age}" name="staff.age" type="hidden"/>
                    <s:textfield value="%{#staff.branch}" name="staff.branch" type="hidden"/>
                    <s:textfield value="%{#staff.hiredate}" name="staff.hiredate" type="hidden"/>
                    <s:textfield value="%{#staff.address}" name="staff.address" type="hidden"/>
                    <s:textfield value="%{#staff.telephone}" name="staff.telephone" type="hidden"/>
                    <s:submit value="修改"/>
                </s:form>
                </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
