<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 15:59
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
    <link href="resources/css/base.css" rel="stylesheet">
</head>
<body>
<div>

<%--<jsp:include page="base.jsp" flush="true"/>--%>
<div>picture</div>
<div>daohang</div>
<div>body</div>
</div>
</body>
</html>
