<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/25
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>注册界面</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/register.js"></script>
</head>
<body>
<fieldset>
    <legend>注册界面</legend>
    <form method="post" action="register">
        <table>
            <tr>
                <td>账　　号：</td>
                <td colspan="2"><input type="text" name="name" placeholder="请输入账号" id="name"></td>
                <td></td>
                <td>5-16位可包含字母数字下划线</td>
            </tr>
            <tr>
                <td>密　　码：</td>
                <td colspan="2"><input type="password" name="pass" placeholder="请输入密码" id="pass"></td>
                <td></td>
                <td>6~18位字母开头可包含字母、数字和下划线</td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td colspan="2"><input type="password" name="pass" placeholder="请输入确认密码" id="repass"></td>
                <td></td>
                <td>两次密码必须相同</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="button" value="注册"></td>
                <td><a href="gologin">已有帐号</a></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
