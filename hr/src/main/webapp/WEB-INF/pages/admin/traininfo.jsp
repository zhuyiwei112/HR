<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 13:07
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
    <title>培训信息</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            $(".publishTrain").click(function () {
                var id=$(this).next().val();
                location.href='goTrainObj?tid='+id+"&type=dep";
            })

            //删除
            $(".del").click(function () {
                var id = $(this).prev().val();
                $.ajax({
                    type:"post",
                    url:"delTrain",
                    data:"id="+id,
                    success:function (obj) {
                        alert(obj);
                        if (obj=="删除成功"){
                            location.href='getTrain?type=0';
                        }
                    }
                })
            })

            //撤销
            $(".repeal").click(function () {
                var id=$(this).next().val();
                $.ajax({
                    type:"post",
                    url:"updateTrain",
                    data:"id="+id+"&type="+1,
                    success:function (obj) {
                        alert(obj);
                        if (obj=="撤销成功"){
                            location.href='getTrain?type=1';
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<jsp:include page="adminMain.jsp" flush="true"/>
<div>
    <div>
        <span>
            <form action="goAddTrain" method="post">
                <input type="submit" value="新增培训">
            </form>
        </span>
    </div>
    <div>
        <a href="getTrain?type=1">已发布</a>
        <a href="getTrain?type=0">未发布</a>
    </div>
    <fieldset>
        <legend>培训信息</legend>
        <div>
            <c:if test="${empty sessionScope.trains}">
                <c:out value="目前还没有发布培训信息"/>
            </c:if>
            <c:if test="${not empty sessionScope.trains}">
                <c:forEach items="${sessionScope.trains}" var="train">
                    <c:if test="${train.isPublish==1}">
                        <div>
                        <span>
                            <input type="button" value="撤销" class="repeal">
                            <input type="hidden" value="${train.id}">
                        </span>
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
                        </div>
                    </c:if>
                    <c:if test="${train.isPublish==0}">
                        <div>
                        <span>
                            <input type="button" value="发布" class="publishTrain">
                            <input type="hidden" value="${train.id}" class="id">
                            <input type="button" value="删除" class="del">
                        </span>
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
                        </div>
                    </c:if>
                </c:forEach>
                <c:if test="${sessionScope.type==1||sessionScope.type==null}">
                    <c:forEach var="i" begin="1" end="${sessionScope.tp}">
                        <a href="getTrain?type=1&cp=${i}">${i}</a>
                    </c:forEach>
                </c:if>
                <c:if test="${sessionScope.type==0}">
                    <c:forEach var="i" begin="1" end="${sessionScope.tp}">
                        <a href="getTrain?type=0&cp=${i}">${i}</a>
                    </c:forEach>
                </c:if>
            </c:if>
        </div>
    </fieldset>
</div>
</body>
</html>
