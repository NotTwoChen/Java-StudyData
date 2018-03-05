<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/3/2
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
        //重置密码
        function resetPwd() {
            var check_admin = document.getElementsByName("check_admin");
            if (check_admin.length === 0) {alert("请至少选择一条数据！");return}
            var admin_ids = [];
            for(var i = 0,l = check_admin.length; i < l ; i++){
                var checkAdmin = check_admin[i];
                if (checkAdmin.checked) {
                    admin_ids.push(checkAdmin.value);
                }
            }
            $.ajax({
                type:'post',
                traditional :true,
                url:'${pageContext.request.contextPath}/admin/resetPassword',
                data:{'admin_ids':admin_ids},
                success:function(data){
                    $("#operate_msg").text(data.message);
                    $("#operate_result_info").show();
                    setTimeout(function () {
                        $("#operate_result_info").hide();
                    },2000)
                }
            });
            //document.getElementById("operate_result_info").style.display = "block";
        }
        //删除
        function deleteAdmin(id) {
            var r = window.confirm("确定要删除此管理员吗？");
            if (r) {
                document.getElementById("operate_result_info").style.display = "block";
                window.location.href = "${pageContext.request.contextPath}/admin/admin_delete?admin_id="+id;
            }
        }
        //全选
        function selectAdmins(inputObj) {
            var inputArray = document.getElementById("datalist").getElementsByTagName("input");
            for (var i = 1; i < inputArray.length; i++) {
                if (inputArray[i].type === "checkbox") {
                    inputArray[i].checked = inputObj.checked;
                }
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
    <jsp:param name="class" value="admin"/>
</jsp:include>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="${pageContext.request.contextPath}/admin/admin_list" method="post">
        <!--查询-->
        <div class="search_add">
            <div>
                模块：
                <select id="selModules" class="select_search" name="moduleId">
                    <option value="0">全部</option>
                    <c:forEach items="${moduleInfos}" var="module">
                        <option value="${module.moduleId}" <c:if test="${pageBean.moduleId == module.moduleId}">selected</c:if>>${module.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>角色：<input type="text" name="roleName" value="${pageBean.roleName}" class="text_search width200" /></div>
            <div><input type="submit" value="搜索" class="btn_search"/></div>
            <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/admin/toAddAdmin';" />
        </div>
        <!--删除和密码重置的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            <span id="operate_msg"></span>
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="th_select_all">
                        <input type="checkbox" onclick="selectAdmins(this);" />
                        <span>全选</span>
                    </th>
                    <th>管理员ID</th>
                    <th>姓名</th>
                    <th>登录名</th>
                    <th>电话</th>
                    <th>电子邮件</th>
                    <th>授权日期</th>
                    <th class="width100">拥有角色</th>
                    <th></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="admin">
                    <tr>
                        <td><input type="checkbox" name="check_admin" value="${admin.adminId}"/></td>
                        <td>${admin.adminId}</td>
                        <td>${admin.name}</td>
                        <td>${admin.adminCode}</td>
                        <td>${admin.telephone}</td>
                        <td>${admin.email}</td>
                        <td><fmt:formatDate value="${admin.enrolldate}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${admin.roleInfos[0].name}</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                <c:forEach items="${admin.roleInfos}" var="role" varStatus="status">
                                    ${role.name}
                                    <c:if test="${!status.last}">、</c:if>
                                </c:forEach>
                            </div>
                        </td>
                        <td class="td_modi">
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/admin/toModiAdmin?admin_id=${admin.adminId}';" />
                            <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.adminId});" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <jsp:include page="../include/pages.jsp">
            <jsp:param name="controller" value="/admin/admin_list"/>
            <jsp:param name="params" value="&moduleId=${pageBean.moduleId}&roleName=${pageBean.roleName}"/>
        </jsp:include>
    </form>
</div>
<!--主要区域结束-->
<jsp:include page="../include/footer.jsp"/>
</body>
</html>
