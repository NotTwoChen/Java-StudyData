<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/20
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工</title>
</head>
<body>
<s:form action="insert">
    <s:textfield label="编号" name="staff.sid"/>
    <s:textfield label="姓名" name="staff.name"/>
    <s:textfield label="年龄" name="staff.age"/>
    <s:textfield label="部门" name="staff.branch"/>
    <s:textfield label="入职" name="staff.hiredate"/>
    <s:textfield label="住址" name="staff.address"/>
    <s:textfield label="电话" name="staff.telephone"/>
    <s:submit value="添加"/>
</s:form>
</body>
</html>
