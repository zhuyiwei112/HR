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
            <li><a href="godep">部门信息</a></li>
            <li><a href="getDep">员工查询</a></li>
            <li><a href="goRC">招聘信息</a></li>
            <li><a href="getDRes?type=admin">查看简历</a></li>
            <li><a href="getTrain?type=1">培训信息</a></li>
            <li><a href="#">员工考勤</a></li>
            <li><a href="#">员工薪资</a></li>
            <li><a href="#">员工奖惩</a></li>
        </ul>
    </div>
</div>
</body>
</html>
