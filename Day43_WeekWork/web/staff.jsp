<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/20
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息</title>
</head>
<body>
    <s:form action="update">
        <s:textfield value="%{#session.staff.sid}" label="编号" name="staff.sid"/>
        <s:textfield value="%{#session.staff.name}" label="姓名" name="staff.name"/>
        <s:textfield value="%{#session.staff.age}" label="年龄" name="staff.age"/>
        <s:textfield value="%{#session.staff.branch}" label="部门" name="staff.branch"/>
        <s:textfield value="%{#session.staff.hiredate}" label="入职" name="staff.hiredate"/>
        <s:textfield value="%{#session.staff.address}" label="住址" name="staff.address"/>
        <s:textfield value="%{#session.staff.telephone}" label="电话" name="staff.telephone"/>
        <s:submit value="编辑"/>
    </s:form>
</body>
</html>
