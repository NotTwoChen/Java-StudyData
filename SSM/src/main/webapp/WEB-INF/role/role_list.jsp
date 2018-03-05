<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/1
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        function deleteRole(id) {
            var r = window.confirm("确定要删除此角色吗？");
            if (r) {
                document.getElementById("operate_result_info").style.display = "block";
                window.location.href = "${pageContext.request.contextPath}/role/role_delete?role_id="+id;
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
    <jsp:param name="class" value="role"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/role/toAddRole';" />
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="role">
                    <tr>
                        <td>${role.roleId}</td>
                        <td>${role.name}</td>
                        <td>
                            <c:forEach items="${role.moduleInfos}" var="moodule" varStatus="status">
                                ${moodule.name}
                                <c:if test="${!status.last}">、</c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/role/toUpdateRole?role_id=${role.roleId}';"/>
                            <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${role.roleId});" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <jsp:include page="../include/pages.jsp">
            <jsp:param name="controller" value="/role/role_list"/>
            <jsp:param name="params" value=""/>
        </jsp:include>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
