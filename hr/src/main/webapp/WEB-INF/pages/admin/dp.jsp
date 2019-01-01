<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 19:30
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
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/dp.js"></script>
    <script>
        $(function () {

        })
    </script>
</head>
<body>
<jsp:include page="adminMain.jsp" flush="true"/>
<div>
    <div id="div1">
        <select id="dep">
            <c:forEach items="${sessionScope.departments}" var="depar">
                <option>${depar.name}</option>
            </c:forEach>
        </select>
        <select id="pos">
            <c:forEach items="${sessionScope.departments[0].positions}" var="pos">
            <option>${pos.name}</option>
            </c:forEach>
        </select>
        <input type="button" id="delPos" value="删除职位">
        <input type="button" id="updatePos" value="修改职位">
        <input type="button" id="return" value="返回">
        <input type="button" id="getEmp" value="查询员工">
    </div>
    <div>
        <table id="table1">
        </table>
        <div id="divpage">
        </div>
    </div>
</div>
</body>
</html>
