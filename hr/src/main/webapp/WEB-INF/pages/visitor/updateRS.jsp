<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/30
  Time: 18:34
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
    <title>修改简历</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/updateRS.js"></script>
    <script>
        $(function () {

        })
    </script>
</head>
<body>
<fieldset>
    <legend>修改简历</legend>
    <form>
        <table>
            <tr>
                <td>姓名：</td>
                <td><input id="rsname" value="${sessionScope.resume.name}"></td>
                <td>性别：</td>
                <td><input id="rssex" value="${sessionScope.resume.sex}"></td>
                <td>出生年月：</td>
                <td><input id="rsbirth" type="date" value="${sessionScope.resume.birth}"></td>
            </tr>
            <tr>
                <td>手机：</td>
                <td><input id="rsphone" value="${sessionScope.resume.phone}"></td>
                <td>学历：</td>
                <td><input id="rsedu" value="${sessionScope.resume.education}"></td>
                <td>专业：</td>
                <td><input id="rsmajor" value="${sessionScope.resume.major}"></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input id="rsmail" value="${sessionScope.resume.email}"></td>
                <td>联系地址：</td>
                <td colspan="3"><input id="rsaddress" value="${sessionScope.resume.address}"></td>
            </tr>
            <tr>
                <td colspan="6" style="text-align: center">工作经验</td>
            </tr>
            <tr>
                <td colspan="6" style="text-align: center"><textarea id="rsexper" style="font-family: 楷体">${sessionScope.resume.experience}</textarea></td>
            </tr>
        </table>
        <div>
            <input id="updateRS" type="button" value="保存">
            <input id="rsid" value="${sessionScope.resume.id}" type="hidden">
            <input id="close" type="button" value="关闭">
        </div>
    </form>
</fieldset>
</body>
</html>
