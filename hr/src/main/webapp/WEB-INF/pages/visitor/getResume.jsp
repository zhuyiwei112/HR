<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/30
  Time: 13:48
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
    <title>查询简历</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/getResume.js"></script>
    <script>
        $(function () {

        })
    </script>
</head>
<body>
<jsp:include page="visitorMain.jsp" flush="true"/>
<div>
    <div>
        <c:if test="${empty sessionScope.resume}">
            <fieldset>
                <legend>填写简历</legend>
                <form>
                    <table>
                        <tr>
                            <td>姓名：</td>
                            <td><input id="rsname"></td>
                            <td>性别：</td>
                            <td><input id="rssex"></td>
                            <td>出生年月：</td>
                            <td><input id="rsbirth" type="date"></td>
                        </tr>
                        <tr>
                            <td>手机：</td>
                            <td><input id="rsphone"></td>
                            <td>学历：</td>
                            <td><input id="rsedu"></td>
                            <td>专业：</td>
                            <td><input id="rsmajor"></td>
                        </tr>
                        <tr>
                            <td>邮箱：</td>
                            <td><input id="rsmail"></td>
                            <td>联系地址：</td>
                            <td colspan="3"><input id="rsaddress"></td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center">工作经验</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center"><textarea id="rsexper" style="font-family: 楷体"></textarea></td>
                        </tr>
                    </table>
                    <div>
                        <input id="addRS" type="button" value="保存">
                        <input id="close" type="button" value="关闭">
                    </div>
                </form>
            </fieldset>
        </c:if>
        <c:if test="${not empty sessionScope.resume}">
            <fieldset>
                <legend>个人简历</legend>
                <form>
                    <table>
                        <tr>
                            <td>姓　　名：</td>
                            <td>${sessionScope.resume.name}</td>
                            <td>性　　别：</td>
                            <td>${sessionScope.resume.sex}</td>
                            <td>出生年月：</td>
                            <td>${sessionScope.resume.birth}</td>
                        </tr>
                        <tr>
                            <td>手　　机：</td>
                            <td>${sessionScope.resume.phone}</td>
                            <td>学　　历：</td>
                            <td>${sessionScope.resume.education}</td>
                            <td>专　　业：</td>
                            <td>${sessionScope.resume.major}</td>
                        </tr>
                        <tr>
                            <td>邮　　箱：</td>
                            <td>${sessionScope.resume.email}</td>
                            <td>联系地址：</td>
                            <td colspan="3">${sessionScope.resume.address}</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center">工作经验</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align: center">${sessionScope.resume.experience}</td>
                        </tr>
                    </table>
                    <div>
                        <input id="updateRS" type="button" value="修改">
                        <input type="hidden" id="rsid" value="${sessionScope.resume.id}">
                        <input id="delRS" type="button" value="删除">
                    </div>
                </form>
            </fieldset>
        </c:if>
    </div>
</div>
</body>
</html>
