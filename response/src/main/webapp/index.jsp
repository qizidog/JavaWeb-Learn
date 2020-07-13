<%@ page contentType="text/html; charset=UTF-8"  %>
<html>
<body>
<h2>这里是response的index目录</h2>
<%--${pageContext.request.contextPath}代表当前项目--%>
<form action="${pageContext.request.contextPath}/rdirect" method="get">
    用户名：<input type="text" name="uname"> <br>
    密码：<input type="password" name="pwd"> <br>
    <input type="submit" value="点击提交">

</form>
</body>
</html>
