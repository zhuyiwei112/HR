<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28
  Time: 10:49
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
    <title>主界面</title>
</head>
<body>
<div>
    <div>
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="visgorcinfo">招聘信息</a></li>
            <li><a href="goAttend">我要上班</a></li>
            <li><a href="getTrainInfo">查看培训</a></li>
            <li><a href="#">考勤情况</a></li>
            <li><a href="#">薪资情况</a></li>
            <li><a href="#">奖惩情况</a></li>
        </ul>
    </div>
</div>
</body>
</html>
