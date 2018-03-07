<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload page</title>
</head>
<body>
<div class="upload">
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"><br/>
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>