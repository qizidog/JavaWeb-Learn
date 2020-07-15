<%@ page contentType="text/html; charset=UTF-8"  %>
<html>
<head>
    <title>表单验证码</title>
    <script type="text/javascript">
        function changeImg(obj,createTypeFlag) {
            // 如果最后不加一个随机数的话，多次点击不会重复请求
            document.getElementById(obj.id).src="${pageContext.request.contextPath}/rpic?createTypeFlag="+createTypeFlag+"&"+Math.random();
        }
    </script>
</head>
<body>
<h2>这里是response的index目录</h2>
<%--${pageContext.request.contextPath}代表当前项目--%>
<form action="${pageContext.request.contextPath}/cpic" method="get">
    用户名：<input type="text" name="uname"> <br>
    密码：<input type="password" name="pwd"> <br>


<%--    数字字母混合验证码：<input type="text" name="validateCode"/>--%>
<%--    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/rpic" id="validateCodeImg1" onclick="changeImg(this,'nl')">--%>
<%--    <br/>--%>
<%--    中文验证码：<input type="text" name="validateCode"/>--%>
<%--    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/rpic?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this,'ch')">--%>
<%--    <br/>--%>
<%--    英文验证码：<input type="text" name="validateCode"/>--%>
<%--    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/rpic?createTypeFlag=l" id="validateCodeImg3" onclick="changeImg(this,'l')">--%>
<%--    <br/>--%>

    数字验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/rpic?createTypeFlag=n" id="validateCodeImg4" onclick="changeImg(this,'n')">
    <br/>

    <input type="submit" value="点击提交">

</form>
</body>
</html>
