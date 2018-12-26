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
    <script>
        $(function () {
            $("#dep").change(function () {
                $("#pos").empty();
                $.ajax({
                    type:"post",
                    url:"getPos",
                    data:"depName="+$("#dep").val(),
                    success:function (obj) {
                        for(var pos in obj){
                            var option=$("<option></option>");
                            option.text(obj[pos].name);
                            var select=$("#pos");
                            select.append(option);
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<jsp:include page="adminMain.jsp" flush="true"/>
<p>
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
<input type="button" value="查询">
</p>
</body>
</html>
