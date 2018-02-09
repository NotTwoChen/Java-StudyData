<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script datatype="json" src="${pageContext.request.contextPath}/js/core.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form action="staff_updateStaff" method="POST">
	<s:hidden name="crmStaff.staffId" value="%{#request.crmStaff.staffId}"/>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td>
			<s:textfield name="crmStaff.loginName" value="%{#request.crmStaff.loginName}"/>
		</td>
	    <td>密码：</td>
	    <td>
			<s:textfield name="crmStaff.loginPwd" value="%{#request.crmStaff.loginPwd}" type="password"/>
		</td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td>
			<s:textfield name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
		</td>
	    <td>性别：</td>
	    <td>
			<s:set var="gender" value="%{#request.crmStaff.gender}"/>
			<s:radio list="{'男','女'}" value="gender" name="crmStaff.gender"/>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="crmStaff.crmPost.crmDepartment.depId" id="departmentSelectId" onchange="changePost(this,'postSelectId')">
			    <option value="">----请--选--择----</option>
				<s:set var="depName" value="%{#request.crmStaff.crmPost.crmDepartment.depName}"/>
				<s:iterator value="#request.crmDepartments" var="department">
					<s:if test="%{#department.depName eq #depName}">
						<option value="${department.depId}" selected="selected">${department.depName}</option>
					</s:if>
					<s:else>
						<option value="${department.depId}">${department.depName}</option>
					</s:else>
				</s:iterator>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="crmStaff.crmPost.postId" id="postSelectId">
				<s:iterator value="#request.crmDepartments" var="dep">
					<s:if test="%{#dep.depName eq #request.crmStaff.crmPost.crmDepartment.depName}">
						<option value="">----请--选--择----</option>
					<s:iterator value="#dep.posts" var="post">
						<s:if test="%{#post.postId eq #request.crmStaff.crmPost.postId}">
							<option value="${requestScope.crmStaff.crmPost.postId}" selected="selected">${requestScope.crmStaff.crmPost.postName}</option>
						</s:if>
						<s:else>
							<option value="${post.postId}">${post.postName}</option>
						</s:else>
					</s:iterator>
					</s:if>
				</s:iterator>
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
			<s:date name="%{#request.crmStaff.onDutyDate}" format="yyyy-MM-dd" var="beginTime"/>
			<s:textfield value="%{#date}" name="crmStaff.onDutyDate" readonly="true" onfocus="c.showMoreDay=true;c.show(this)"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
</body>
</html>
