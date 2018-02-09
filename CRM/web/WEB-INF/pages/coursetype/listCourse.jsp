<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别 --%>
    	<a href="<s:url action="uiAction_coursetype_addOrEditCourse"/>">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<%--条件查询 start --%>

<s:form action="courseType_findByASP" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">课程类别：</td>
	    <td>
			<s:textfield name="crmCourseType.courseName" size="30" value="%{#request.crmCourseType.courseName}"/>
		</td>
	  </tr>
	  <tr>
	    <td >课程简介：</td>
	    <td >
			<s:textfield name="crmCourseType.remark" size="30" value="%{#request.crmCourseType.remark}"/>
		</td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td >
			<s:textfield name="totalStart" size="12" value="%{#request.totalStart}"/>
			至
			<s:textfield name="totalEnd" size="12" value="%{#request.totalEnd}"/>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td >
			<s:textfield name="lessonCostStart" size="12" value="%{#request.lessonCostStart}"/>
			至
			<s:textfield name="lessonCostEnd" size="12" value="%{#request.lessonCostEnd}"/>
	  </tr>
	</table>
</s:form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="14%" align="center">名称</td>
    <td width="33%" align="center">简介</td>
    <td width="13%" align="center">总学时</td>
    <td width="18%" align="center">收费标准</td>
	<td width="11%" align="center">编辑</td>
  </tr>
  <%--数据展示，单行：tabtd1；双行：tabtd2 --%>
	<s:iterator value="#request.pageBean.list" var="courseType" status="status">
		<s:if test="#status.odd">
			<tr class="tabtd1">
		</s:if>
		<s:if test="#status.even">
			<tr class="tabtd2">
		</s:if>
		<td align="center"><s:property value="#courseType.courseName"/></td>
		<td align="center"><s:property value="#courseType.remark"/></td>
		<td align="center"><s:property value="#courseType.total"/></td>
		<td align="center"><s:property value="#courseType.courseCost"/></td>
		<td width="11%" align="center">
			<s:url action="courseType_findByCourseTypeId" var="editCourse">
				<s:param name="crmCourseType.courseTypeId" value="#courseType.courseTypeId"/>
			</s:url>
			<s:a href="%{#editCourse}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" alt="编辑"/></s:a>
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
					<a href="<s:url action="courseType_findAll">
					<s:param name="nowPageIndex" value="1"/>
					<s:param name="crmCourseType.courseName" value="%{#request.crmCourseType.courseName}"/>
					<s:param name="crmCourseType.remark" value="%{#request.crmCourseType.remark}"/>
					<s:param name="totalStart" value="%{#request.totalStart}"/>
					<s:param name="totalEnd" value="%{#request.totalEnd}"/>
					<s:param name="lessonCostStart" value="%{#request.lessonCostStart}"/>
					<s:param name="lessonCostEnd" value="%{#request.lessonCostEnd}"/>
								</s:url> ">[首页]</a>
				</s:if>
				<s:if test="%{#request.pageBean.nowPageIndex != 1}">
					<a href="<s:url action="courseType_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex-1}"/>
					<s:param name="crmCourseType.courseName" value="%{#request.crmCourseType.courseName}"/>
					<s:param name="crmCourseType.remark" value="%{#request.crmCourseType.remark}"/>
					<s:param name="totalStart" value="%{#request.totalStart}"/>
					<s:param name="totalEnd" value="%{#request.totalEnd}"/>
					<s:param name="lessonCostStart" value="%{#request.lessonCostStart}"/>
					<s:param name="lessonCostEnd" value="%{#request.lessonCostEnd}"/>
								</s:url> ">[上一页]</a>
				</s:if>
				<s:iterator  begin="%{#request.pageBean.startPageIndex}" end="%{#request.pageBean.endPageIndex}" var="page">
					<s:if test="%{#request.pageBean.nowPageIndex == #page}">
						${page}
					</s:if>
					<s:else>
						<a href="<s:url action="courseType_findAll">
					<s:param name="nowPageIndex" value="#page"/>
					<s:param name="crmCourseType.courseName" value="%{#request.crmCourseType.courseName}"/>
					<s:param name="crmCourseType.remark" value="%{#request.crmCourseType.remark}"/>
					<s:param name="totalStart" value="%{#request.totalStart}"/>
					<s:param name="totalEnd" value="%{#request.totalEnd}"/>
					<s:param name="lessonCostStart" value="%{#request.lessonCostStart}"/>
					<s:param name="lessonCostEnd" value="%{#request.lessonCostEnd}"/>
								</s:url> ">[${page}]</a>
					</s:else>
				</s:iterator>
				<s:if test="%{#request.pageBean.nowPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="courseType_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.nowPageIndex+1}"/>
					<s:param name="crmCourseType.courseName" value="%{#request.crmCourseType.courseName}"/>
					<s:param name="crmCourseType.remark" value="%{#request.crmCourseType.remark}"/>
					<s:param name="totalStart" value="%{#request.totalStart}"/>
					<s:param name="totalEnd" value="%{#request.totalEnd}"/>
					<s:param name="lessonCostStart" value="%{#request.lessonCostStart}"/>
					<s:param name="lessonCostEnd" value="%{#request.lessonCostEnd}"/>
								</s:url> ">[下一页]</a>
				</s:if>
				<s:if test="%{#request.pageBean.endPageIndex != #request.pageBean.pageCount}">
					<a href="<s:url action="courseType_findAll">
					<s:param name="nowPageIndex" value="%{#request.pageBean.pageCount}"/>
					<s:param name="crmCourseType.courseName" value="%{#request.crmCourseType.courseName}"/>
					<s:param name="crmCourseType.remark" value="%{#request.crmCourseType.remark}"/>
					<s:param name="totalStart" value="%{#request.totalStart}"/>
					<s:param name="totalEnd" value="%{#request.totalEnd}"/>
					<s:param name="lessonCostStart" value="%{#request.lessonCostStart}"/>
					<s:param name="lessonCostEnd" value="%{#request.lessonCostEnd}"/>
								</s:url> ">[尾页]</a>
				</s:if>
        </span>
		 </td>
	 </tr>
 </table>
</body>
</html>
