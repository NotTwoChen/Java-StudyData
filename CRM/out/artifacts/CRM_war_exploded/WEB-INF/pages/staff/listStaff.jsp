<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>

	<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/core.js" type="text/javascript"></script>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
</head>

<body >
<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td class="topg"></td>
	</tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang" width="100%">
	<tr>
		<td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif" alt=""/></td>
		<td width="39%" align="left">[员工管理]</td>

		<td width="57%" align="right">
			<%--高级查询 --%>
			<a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"  alt=""/></a>
			<%--员工注入 --%>
			<a href="<s:url action="department_findAll3"/>">
				<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" alt="" />
			</a>

		</td>
		<td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif" alt=""/></td>
	</tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form id="conditionFormId" action="staff_findAll" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
		<tr>
			<td width="80px">部门：</td>
			<td width="200px">
				<s:select name="crmStaff.crmPost.crmDepartment.depId" list="%{#request.crmDepartments}" listKey="depId" listValue="depName" headerKey="" headerValue="----请--选--择----" onchange="changePost(this,'postSelectId')"/>
			</td>
			<td width="80px" >职务：</td>
			<td width="200px" >
				<s:select name="crmStaff.crmPost.postId" list="%{#request.crmPosts}" listKey="postId" listValue="postName" headerKey="" headerValue="----请--选--择---" id="postSelectId"/>
			</td>
			<td width="80px">姓名：</td>
			<td width="200px" >
				<s:textfield name="crmStaff.staffName" size="12"/>
			</td>
			<td ></td>
		</tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
	<tr>
		<td ><img src="${pageContext.request.contextPath}/images/result.gif" alt=""/></td>
	</tr>
</table>

<table width="100%" border="1" >
	<tr class="henglan" style="font-weight:bold;">
		<td width="10%" align="center">员工姓名</td>
		<td width="6%" align="center">性别</td>
		<td width="12%" align="center">入职时间</td>
		<td width="15%" align="center">所属部门</td>
		<td width="10%" align="center">职务</td>
		<td width="10%" align="center">编辑</td>
	</tr>
	<s:iterator value="#request.pageBean.list" var="crmStaff" status="staff">
		<s:if test="#staff.odd">
			<tr class="tabtd1">
		</s:if>
		<s:if test="#staff.even">
			<tr class="tabtd2">
		</s:if>
		<td align="center"><s:property value="#crmStaff.staffName"/></td>
		<td align="center"><s:property value="#crmStaff.gender"/></td>
		<td align="center"><s:date name="#crmStaff.onDutyDate" format="yyyy-MM-dd"/></td>
		<td align="center"><s:property value="#crmStaff.crmPost.crmDepartment.depName"/></td>
		<td align="center"><s:property value="#crmStaff.crmPost.postName"/></td>
		<td width="7%" align="center">
			<s:url action="staff_editStaff" var="editStaff">
				<s:param name="crmStaff.staffId" value="#crmStaff.staffId"/>
			</s:url>
			<s:a href="%{editStaff}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"  alt=""/></s:a>
		</td>
		</tr>
	</s:iterator>

</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="right">
			<span>第${requestScope.pageBean.nowPageIndex}/${requestScope.pageBean.pageCount}页</span>
			<span>
				<s:if test="%{#request.pageBean.startPageIndex > 1}">
					<a href="<s:url action="staff_findAll">
					<s:param name="nowPageIndex" value="1"/>
					<s:param name="crmStaff.crmPost.crmDepartment.depId" value="%{#request.crmStaff.crmPost.crmDepartment.depId}"/>
					<s:param name="crmStaff.crmPost.postId" value="%{#request.crmStaff.crmPost.postId}"/>
					<s:param name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
								</s:url> ">[首页]</a>
				</s:if>
				<s:if test="%{#request.pageBean.nowPageIndex != 1}">
					<a href="<s:url action="staff_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex-1}"/>
					<s:param name="crmStaff.crmPost.crmDepartment.depId" value="%{#request.crmStaff.crmPost.crmDepartment.depId}"/>
					<s:param name="crmStaff.crmPost.postId" value="%{#request.crmStaff.crmPost.postId}"/>
					<s:param name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
								</s:url> ">[上一页]</a>
				</s:if>
				<s:iterator  begin="%{#request.pageBean.startPageIndex}" end="%{#request.pageBean.endPageIndex}" var="page">
					<s:if test="%{#request.pageBean.nowPageIndex == #page}">
						${page}
					</s:if>
					<s:else>
						<a href="<s:url action="staff_findAll">
					<s:param name="nowPageIndex" value="#page"/>
					<s:param name="crmStaff.crmPost.crmDepartment.depId" value="%{#request.crmStaff.crmPost.crmDepartment.depId}"/>
					<s:param name="crmStaff.crmPost.postId" value="%{#request.crmStaff.crmPost.postId}"/>
					<s:param name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
								</s:url> ">[${page}]</a>
					</s:else>
				</s:iterator>
				<s:if test="%{#request.pageBean.nowPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="staff_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex+1}"/>
					<s:param name="crmStaff.crmPost.crmDepartment.depId" value="%{#request.crmStaff.crmPost.crmDepartment.depId}"/>
					<s:param name="crmStaff.crmPost.postId" value="%{#request.crmStaff.crmPost.postId}"/>
					<s:param name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
								</s:url> ">[下一页]</a>
				</s:if>
				<s:if test="%{#request.pageBean.endPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="staff_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.pageCount}"/>
					<s:param name="crmStaff.crmPost.crmDepartment.depId" value="%{#request.crmStaff.crmPost.crmDepartment.depId}"/>
					<s:param name="crmStaff.crmPost.postId" value="%{#request.crmStaff.crmPost.postId}"/>
					<s:param name="crmStaff.staffName" value="%{#request.crmStaff.staffName}"/>
								</s:url> ">[尾页]</a>
				</s:if>
        </span>
		</td>
	</tr>
</table>
</body>
</html>
