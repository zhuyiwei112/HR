<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/2
  Time: 16:39
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
    <title>录用通知</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            //参加面试
            $("#join").click(function () {
                var pid=$("#pid").val();
                var rid=$("#rid").val();
                $.ajax({
                    type:"post",
                    url:"addEmp",
                    data:"pid="+pid+"&rid="+rid,
                    success:function (obj) {
                        alert(obj);
                        if (obj=="确认成功"){
                            location.href='visgorcinfo';
                        }
                    }
                })
            })
            //取消面试
            $("#cancel").click(function () {
                var rid=$("#rid").val();
                if (confirm("放弃本次面试")){
                    $.ajax({
                        type:"post",
                        url:"cancelDR",
                        data:"rid="+rid,
                        success:function (obj) {
                            location.href='visgorcinfo';
                        }
                    })
                }
            })
        })
    </script>
</head>
<body>
<jsp:include page="visitorMain.jsp" flush="true"/>
<div>
    <c:if test="${empty sessionScope.deliver}">
        <c:out value="还没有收到面试通知"/>
    </c:if>
    <c:if test="${not empty sessionScope.deliver}">
        <%--<c:if test="${sessionScope.delivers}"--%>
        <table>
            <tr>
                <td>部　　门：</td>
                <td>${sessionScope.deliver.recruit.position.department.name}</td>
            </tr>
            <tr>
                <td>职　　位：</td>
                <td>${sessionScope.deliver.recruit.position.name}</td>
            </tr>
            <tr>
                <td>面试时间：</td>
                <td>${sessionScope.deliver.time}</td>
            </tr>
            <tr>
                <td>参加面试：</td>
                <td>
                    <input type="hidden" value="${sessionScope.deliver.resume.id}" id="rid">
                    <input type="hidden" value="${sessionScope.deliver.recruit.position.id}" id="pid">
                    <input type="button" value="确认" id="join">
                    <input type="button" value="取消" id="cancel">
                </td>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>
