<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/4
  Time: 11:10
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
    <title>培训</title>
</head>
<body>
<jsp:include page="employeeMain.jsp" flush="true"/>
<div>
    <div>
        <fieldset>
            <legend>培训信息</legend>
            <c:if test="${empty sessionScope.trains}">
                <c:out value="目前木有新的培训"/>
            </c:if>
            <c:if test="${not empty sessionScope.trains}">
                <c:forEach items="${sessionScope.trains}" var="train">
                    <table>
                        <tr>
                            <td>培训主题：</td>
                            <td>${train.request}</td>
                        </tr>
                        <tr>
                            <td>开始时间：</td>
                            <td>${train.beginTime}</td>
                        </tr>
                        <tr>
                            <td>结束时间：</td>
                            <td>${train.endTime}</td>
                        </tr>
                        <tr>
                            <td>培训内容：</td>
                            <td>${train.content}</td>
                        </tr>
                    </table>
                    <hr>
                </c:forEach>
                <c:forEach begin="1" var="i" end="${sessionScope.tp}">
                    <a href="getTrainInfo?cp=${i}">${i}</a>
                </c:forEach>
            </c:if>
        </fieldset>
    </div>
</div>
</body>
</html>
