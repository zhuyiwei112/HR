<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 16:27
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
    <title></title>
</head>
<body>
<fieldset style="width: 200px">
    <legend>登入</legend>
    <form action="login" method="post">
        <table>
            <tr>
                <td>帐号:</td>
                <td colspan="2"><input type="text" name="name" required></td>
                <td></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td colspan="2"><input type="password" name="pass" required></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">
                    <select name="type">
                        <option>游客</option>
                        <option>员工</option>
                        <option>管理员</option>
                    </select>
                </td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登入"></td>
                <td><a href="#">还没帐号？</a></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
