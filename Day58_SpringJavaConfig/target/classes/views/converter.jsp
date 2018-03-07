<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>converter 演示</title>
    <script type="text/javascript" src="../assets/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="resp">
    <button onclick="req()">点我</button>
</div>
</body>
<script type="text/javascript">
    function req() {
        $.ajax({
            url:"convert",
            data:"1-hello",//后台会根据—分割数据
            type:"POST",
            contentType:"application/x-wsh",//这里设置的就是自定义媒体类型
            success:function(data){
                $("#resp").html(data);
            }

        });
    }
</script>
</html>