<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28
  Time: 13:22
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
<div>
    <div>
        <ul>
            <li><a href="getRS">我的简历</a></li>
            <li><a href="visgorcinfo">招聘信息</a></li>
            <li><a href="getDRes?type=visitor">录用通知</a></li>
        </ul>
    </div>
</div>
</body>
</html>
