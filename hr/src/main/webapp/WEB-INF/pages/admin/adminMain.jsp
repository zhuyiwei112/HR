<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 19:10
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
    <title>管理员主页</title>
</head>
<body>
<div>
    <div>
        <ul>
            <li><a href="#">部门/职位</a></li>
            <li><a href="#">员工</a></li>
            <li><a href="#">考勤</a></li>
            <li><a href="#">招聘信息</a></li>
            <li><a href="#">薪资</a></li>
            <li><a href="#">奖惩</a></li>
        </ul>
    </div>
</div>
</body>
</html>
