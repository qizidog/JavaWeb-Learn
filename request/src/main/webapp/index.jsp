<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录页面</h1>
<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="uname"> <br>
        密&nbsp;&nbsp;码：<input type="password" name="pwd"> <br>
        爱好： <br>
        <input type="checkbox" name="hobbys" value="妹纸">妹纸
        <input type="checkbox" name="hobbys" value="代码">代码
        <input type="checkbox" name="hobbys" value="睡觉">睡觉
        <input type="checkbox" name="hobbys" value="吃饭">吃饭 <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
