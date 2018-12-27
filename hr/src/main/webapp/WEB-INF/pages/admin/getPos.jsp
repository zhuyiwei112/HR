<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/26
  Time: 20:18
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
<div id="div2" style="display: block">
    <table>
        <tr>
            <td>职位名称</td><td>创建时间</td><td></td><td></td>
        </tr>
        <c:forEach items="${sessionScope.positions}" var="pos">
            <tr>
                    <%--<td>${pos.department.name}</td>--%>
                <td>${pos.name}</td>
                <td>${pos.time}</td>
                <td><input type="button" value="删除职位"></td>
                <input type="hidden" class="id" value="${pos.id}">
                <td><input type="button" value="修改职位"></td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach var="i" begin="1" end="${sessionScope.tp1}">
        ${i}
        <a href="getPosition?cp=${i}">${i}</a>
    </c:forEach>
</div>
</body>
</html>
