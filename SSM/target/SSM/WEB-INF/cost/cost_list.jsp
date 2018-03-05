<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/2/6
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort(btnObj) {
            var value = btnObj.value;
            if (value === "基费"){value = "base_cost"}else {value = "base_duration"}
            var className = btnObj.className;
            if (className === "sort_desc"){
                btnObj.className = "sort_asc";
                className = "asc";
            } else {
                btnObj.className = "sort_desc";
                className = "desc";
            }
            window.location.href = "${pageContext.request.contextPath}/cost/cost_list?sort="+className+"&value="+value;

        }

        //启用
        function startFee() {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
            document.getElementById("operate_result_info").style.display = "block";
        }
        //删除
        function deleteFee(id) {
            var r = window.confirm("确定要删除此资费吗？");
            if (r){
                document.getElementById("operate_result_info").style.display = "block";
                window.location.href = "${pageContext.request.contextPath}/cost/deleteCost?id="+id;
            }
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<jsp:include page="../include/header.jsp"/>
<!--Logo区域结束-->
<!--导航区域开始-->
<jsp:include page="../include/navi.jsp">
    <jsp:param name="class" value="cost"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                <input type="button" value="基费" class="sort_<c:choose><c:when test="${pageBean.value == 'base_cost'}">${pageBean.sort}</c:when><c:otherwise>asc</c:otherwise></c:choose>" onclick="sort(this);" />
                <input type="button" value="时长" class="sort_<c:choose><c:when test="${pageBean.value == 'base_duration'}">${pageBean.sort}</c:when><c:otherwise>asc</c:otherwise></c:choose>" onclick="sort(this);" />
            </div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/cost/toAddCost';" />
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>资费ID</th>
                    <th class="width100">资费名称</th>
                    <th>基本时长</th>
                    <th>基本费用</th>
                    <th>单位费用</th>
                    <th>创建时间</th>
                    <th>开通时间</th>
                    <th class="width50">状态</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="cost">
                    <tr>
                        <td>${cost.id}</td>
                        <td><a href="${pageContext.request.contextPath}/cost/cost_detail?id=${cost.id}">${cost.name}</a></td>
                        <td>
                            <c:if test="${cost.baseDuration != null}">
                                ${cost.baseDuration} 小时
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${cost.baseCost != null}">
                                ${cost.baseCost} 元
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${cost.unitCost != null}">
                                ${cost.unitCost} 元/小时
                            </c:if>
                        </td>
                        <td><fmt:formatDate value="${cost.creatime}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${cost.startime != null}">
                                    <fmt:formatDate value="${cost.startime}" pattern="yyyy-MM-dd"/>
                                </c:when>
                                <c:otherwise>
                                    未开通
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${cost.status == '1'}">
                                    暂停
                                </c:when>
                                <c:otherwise>
                                    开通
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <input type="button" value="启用" class="btn_start" onclick="startFee();" />
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/cost/toUpdateCost?id=${cost.id}';" />
                            <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${cost.id});" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>业务说明：<br />
                1、创建资费时，状态为暂停，记载创建时间；<br />
                2、暂停状态下，可修改，可删除；<br />
                3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
            </p>
        </div>
        <!--分页-->
        <jsp:include page="../include/pages.jsp">
            <jsp:param name="controller" value="/cost/cost_list"/>
            <jsp:param name="params" value="&sort=${pageBean.sort}&value=${pageBean.value}"/>
        </jsp:include>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
