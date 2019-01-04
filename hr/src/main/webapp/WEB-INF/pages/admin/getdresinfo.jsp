<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/2
  Time: 13:01
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
            $(".sendDR").click(function () {
                var id=$(this).next().val();
                $.ajax({
                    type:"post",
                    url:"sendDR",
                    data:"idDR="+id,
                    success:function (obj) {
                        alert(obj);
                        location.href='getDRes?type=admin';
                    }
                })
            })

            $(".hideDR").click(function () {
                var id=$(this).prev().val();
                $.ajax({
                    type:"post",
                    url:"updateDR",
                    data:"idDR="+id,
                    success:function (obj) {
                        location.href='getDRes?type=admin';
                    }
                })
            })
        })
    </script>
</head>
<body>
<div>

    <fieldset>
        <legend>简历信息</legend>
        <c:if test="${empty sessionScope.delivers}">
            <c:out value="目前没有人投递简历"/>
        </c:if>
        <c:if test="${not empty sessionScope.delivers}">
            <c:if test="${deliver.isRead!=0}">
                <c:out value="目前没有人投递简历"/>
            </c:if>
            <c:forEach items="${sessionScope.delivers}" var="deliver">
                <c:if test="${deliver.isRead==0}">
                    <table>
                        <tr>
                            <td>姓　　名：</td>
                            <td>${deliver.resume.name}</td>
                            <td>性　　别：</td>
                            <td>${deliver.resume.sex}</td>
                            <td>出生年月：</td>
                            <td>${deliver.resume.birth}</td>
                        </tr>
                        <tr>
                            <td>手　　机：</td>
                            <td>${deliver.resume.phone}</td>
                            <td>学　　历：</td>
                            <td>${deliver.resume.education}</td>
                            <td>专　　业：</td>
                            <td>${deliver.resume.major}</td>
                        </tr>
                        <tr>
                            <td>邮　　箱：</td>
                            <td>${deliver.resume.email}</td>
                            <td>联系地址：</td>
                            <td colspan="3">${deliver.resume.address}</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center">工作经验</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center">${deliver.resume.experience}</td>
                        </tr>
                    </table>
                    <div>
                        <form action="sendDR" method="post">
                            <input type="button" value="发送邀请" class="sendDR">
                            <input type="hidden" name="idDR" value="${deliver.id}">
                            <input type="button" value="隐藏该简历" class="hideDR">
                        </form>
                    </div>
                    <hr>
                </c:if>
            </c:forEach>
        </c:if>
    </fieldset>
</div>
</body>
</html>
