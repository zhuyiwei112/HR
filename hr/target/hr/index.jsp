<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 17:00
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
<jsp:include page="WEB-INF/pages/admin/adminMain.jsp" flush="true"/>
<jsp:include page="WEB-INF/pages/employee/employeeMain.jsp" flush="true"/>
<jsp:include page="WEB-INF/pages/visitor/visitorMain.jsp" flush="true"/>
<a href="gologin">login</a>
<a href="godep">dep</a>
</body>
</html>
