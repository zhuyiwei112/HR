<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/1
  Time: 14:48
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
    <title>招聘信息</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/js/rcinfo.js"></script>
    <script>
        $(function () {

        })
    </script>
</head>
<body>
<div>
    <div>
        <fieldset>
            <legend>招聘信息</legend>
            <c:forEach items="${sessionScope.RCs}" var="recruit">
                <c:if test="${not empty recruit.time}">
                    <table>
                        <tr>
                            <td>招聘主题</td>
                            <td>招聘人数</td>
                            <td>发布时间</td>
                            <td>招聘详情</td>
                        </tr>
                        <tr>
                            <td>${recruit.theme}</td>
                            <td>${recruit.number}</td>
                            <td>${recruit.time}</td>
                            <td><input class="notEmptyTime" type="button" value="查看"></td>
                        </tr>
                    </table>
                    <div style="display: none">
                        <span>
                        <input type="hidden" value="${recruit.id}">
                        <input type="button" class="sendRC" value="投递简历">
                        <input type="hidden" value="${recruit.position.id}">
                    </span>
                        <table>
                            <tr>
                                <td>招聘要求</td>
                            </tr>
                            <tr>
                                <td>${recruit.request}</td>
                            </tr>
                            <tr>
                                <td>招聘内容</td>
                            </tr>
                            <tr>
                                <td>${recruit.content}</td>
                            </tr>
                        </table>
                    </div>
                </c:if>
            </c:forEach>

        </fieldset>
    </div>

    <div>
        <div id="rcinfo" style="display: none">
            <div>
                <%--${sessionScope.recruits}--%>
                <c:forEach items="${sessionScope.recruits}" var="recruit">
                    <table>
                        <tr>
                            <td>招聘主题</td>
                            <td>招聘人数</td>
                            <td>发布时间</td>
                            <td>招聘详情</td>
                        </tr>
                        <tr>
                            <td>${recruit.theme}</td>
                            <td>${recruit.number}</td>
                            <c:if test="${empty recruit.time}">
                                <td>未发布</td>
                            </c:if>
                            <c:if test="${not empty recruit.time}">
                                <td>${recruit.time}</td>
                            </c:if>
                            <td><input class="checkRCdetail" type="button" value="查看"></td>
                        </tr>
                    </table>
                    <div style="display: none">
                            <%--<span><h6>详情</h6></span>--%>
                        <span>
                        <c:if test="${empty recruit.time}">
                            <input type="button" class="publishRC" value="发布">
                        </c:if>
                        <c:if test="${not empty recruit.time}">
                            <input type="button" class="publishRC" value="撤销">
                        </c:if>
                        <input type="hidden" class="id" value="${recruit.id}">
                        <input type="button" class="delRC" value="删除">
                        <input type="hidden" value="${recruit.position.id}">
                        <%--<input type="button" class="updateRC" value="修改">--%>
                    </span>
                        <table>
                            <tr>
                                <td>招聘要求</td>
                            </tr>
                            <tr>
                                <td>${recruit.request}</td>
                            </tr>
                            <tr>
                                <td>招聘内容</td>
                            </tr>
                            <tr>
                                <td>${recruit.content}</td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            </div>
        </div>
</div>
</body>
</html>
