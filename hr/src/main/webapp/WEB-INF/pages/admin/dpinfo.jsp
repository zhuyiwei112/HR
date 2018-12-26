<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/25
  Time: 15:37
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
    <title>部门信息</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/dpinfo.js"></script>
    <script>

    </script>
</head>
<body>
<jsp:include page="adminMain.jsp" flush="true"/>

<div>
    <input type="button" value="新增部门" id="addDep">
</div>
<div>
    <table>
        <tr>
            <td>部门名称</td><td>创建时间</td><td></td><td></td>
        </tr>
    <c:forEach items="${sessionScope.departments}" var="depar">
        <tr>
            <input type="hidden" class="id" value="${depar.id}">
            <td>${depar.name}</td>
            <td>${depar.time}</td>
            <td><input type="button" class="delDep" value="删除"></td>
            <td><input type="button" class="updateDep" value="修改"></td>
        </tr>
    </c:forEach>
    </table>
    <c:forEach var="i" begin="1" end="${sessionScope.tp}">
        <a href="godep?cp=${i}">${i}</a>
    </c:forEach>
</div>
</body>
</html>
