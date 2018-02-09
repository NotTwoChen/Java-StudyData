<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	<script src="${pageContext.request.contextPath}/js/core.js" type="text/javascript"></script>
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

<s:form action="staff_add" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td>
			<s:textfield name="crmStaff.loginName"/>
			<%--<input type="text" name="loginName" value="" /> --%>
		</td>
	    <td>密码：</td>
	    <td>
			<s:textfield name="crmStaff.loginPwd" type="password"/>
			<%--<input type="password" name="loginPwd" /> --%>
		</td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td>
			<s:textfield name="crmStaff.staffName"/>
			<%--<input type="text" name="staffName" value="" id="staffAction_add_staffName"/> --%>
		</td>
	    <td>性别：</td>
	    <td>
			<s:radio list="{'男','女'}" name="crmStaff.gender"/>
			<%--<input type="radio" name="gender"  value="男"/>男--%>
	    	<%--<input type="radio" name="gender"  value="女"/>女--%>
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="crmStaff.crmPost.crmDepartment.depId"onchange="changePost(this,'postSelectId')">
			    <option value="">----请--选--择----</option>
				<s:iterator value="#request.crmDepartments" var="department">
					<option value="${department.depId}">${department.depName}</option>
				</s:iterator>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select id="postSelectId" name="crmStaff.crmPost.postId">
	    		<option>----请--选--择----</option>
				<option>---请先选择部门---</option>
	    	</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
			<s:textfield name="crmStaff.onDutyDate" readonly="true" onfocus="c.showMoreDay=true;c.show(this)"/>
	    	<%--<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />--%>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
</body>
</html>
