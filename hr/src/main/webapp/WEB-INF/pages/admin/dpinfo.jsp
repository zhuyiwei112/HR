<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
        $(function () {

        })
    </script>
</head>
<body>
<jsp:include page="adminMain.jsp" flush="true"/>

<div id="div1">
    <input type="button" value="新增部门" id="addDep">
    <input id="bdp1" type="button" value="删除部门">
    <input id="bdp2" type="button" value="修改部门">
    <input id="bps1" type="button" value="新增职位">
    <input id="bps2" type="button" value="查询职位">
</div>

<div>
    <table>
        <tr>
            <td>部门名称</td><td>创建时间</td><td></td><td></td><td></td><td></td>
        </tr>
        <c:if test="${empty sessionScope.departments}">
            <tr>
                <td colspan="6" style="color: red">
                    本公司未有部门
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.departments}">
            <c:forEach items="${sessionScope.departments}" var="depar">
                <tr>
                    <input type="hidden" class="id" value="${depar.id}">
                    <td>${depar.name}</td>
                    <td>${depar.time}</td>
                    <td><input style="display: none" type="button" class="delDep" value="删除部门"></td>
                    <td><input style="display: none" type="button" class="addPos" value="新增职位"></td>
                    <td><input style="display: none" type="button" class="updateDep" value="修改部门"></td>
                    <%--<td><input style="display: none" type="button" class="getPos" value="查询职位"></td>--%>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:forEach var="i" begin="1" end="${sessionScope.tp}">
        <a href="godep?cp=${i}">${i}</a>
    </c:forEach>
</div>

<%--<div id="div2">
    <table>
        <tr>
            <td>职位名称</td><td>创建时间</td><td></td><td></td>
        </tr>
        <c:forEach items="${sessionScope.positions}" var="pos">
            <c:if test="${empty pos}">
                <tr>
                    <td colspan="2">${"该部门还没有职位"}</td>
                </tr>
            </c:if>
            <c:if test="${not empty pos}">
            <tr>
                &lt;%&ndash;<td>${pos.department.name}</td>&ndash;%&gt;
                <td>${pos.name}</td>
                <td>${pos.time}</td>
                <td><input type="button" class="delPos" value="删除职位"></td>
                <input type="hidden" class="id" value="${pos.id}">
                <td><input type="button"  class="updatePos" value="修改职位"></td>
            </tr>
            </c:if>
        </c:forEach>
    </table>--%>
<%--    <c:forEach var="i" begin="1" end="${sessionScope.tpos}">
        <a href="getPosition?cp=${i}">${i}</a>
    </c:forEach>--%>
</div>
</body>
</html>
