<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 王森浩
  Date: 2018/1/17
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ognl</title>
</head>
<body>
<%--
    如果使用单引号括起来
    会认为hello是一个字符串

    如果不用单引号括起来
    会认为hello是一个表达式
--%>
<s:property value="'hello'"/>
<%--
    使用#,调用request对象
    使用.找到request对象中的hello属性
--%>
<s:property value="#request.hello"/>
<s:property value="@java.lang.Integer@MAX_VALUE"/>
<s:property value="@@abs(-100)"/>
<%--
    获取ActionContext中的键值对
    键位show
    输出对应的值
--%>
<s:property value="#show"/>
<%--
    获得栈顶的元素的name属性
--%>
<s:property value="name"/>
${name}

<s:set var="v" value="'value'" scope="session"/>
${sessionScope.v}

<%--<s:action name="hello"/>--%>

<s:set value="'B'" var="grade"/>
<s:if test="#grade == 'A'">
    优秀
</s:if>
<s:elseif test="#grade == 'B'">
    尚需努力
</s:elseif>

<%--
    保存一个路径
    变量名为:books
--%>
<s:url value="book.action" var="books"/>
<a href="${books}">来吧我的宝贝</a>
<%--
    struts2封装好的超链接标签
    可以使用ignl表达式找到上面的url标签存起来的路径
--%>
<s:a action="%{books}">哈哈哈</s:a>
<%--
    namespace属性:指定命名空间
--%>
<s:form action="book" method="POST">
    <%--
        通过ognl表达式提交参数
        这里会检查BookAction中是否有username属性
        没有的话就会报错
    --%>
    <s:textfield name="username"/>
    <%--
        list:可选项
        value:默认选中的
        name:对应bookAction中的某个属性

        所以,这三个属性,都在使用ognl表达式
    --%>
    <s:set var="sex" value="'女'"/>
    <%--
        如果使用${},那么会去找某个属性
        下面直接{}
        是在使用ognl表达式创建一个集合
    --%>
    <s:radio list="{'男','女'}" value="sex" name="sex"/>
    <s:select list="{'武汉','大连','北京','圣安东尼奥'}" name="city"/>
    <s:submit/>

</s:form>
</body>
</html>
