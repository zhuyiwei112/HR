<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 20:13
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
    <title>培训对象</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            var id=$(".tid").val();
            $(".fixed").click(function () {
                if ($(":checked").length!=0) {
                    var ids = "ids=";
                    var butid = $(this).attr("id");
                    $(":checked").each(function () {
                        ids += $(this).val() + "&ids=";
                    })
                    ids = ids.substr(0, ids.length - 5);
                    $.ajax({
                        type:"post",
                        url:"addTrainObj",
                        data:ids+"&tid="+id+"&type="+butid,
                        success:function (obj) {
                            alert(obj);
                            if (obj=="发布成功"){
                                location.href='getTrain?type=1';
                            }
                        }
                    })
                }else {
                    alert("请选择培训对象");
                }
            })


            //取消发布
            $(".cancelTrain").click(function () {
                location.href='getTrain?type=1';
            })
            //选择部门
            $("#checkDep").click(function () {
                location.href='goTrainObj?tid='+id+"&type=dep";
            })
            //选择员工
            $("#checkEmp").click(function () {
                location.href='goTrainObj?tid='+id+"&type=emp";
            })
        })
    </script>
</head>
<body>
<div>
    <div>
        <fieldset>
            <legend><input type="button" value="面向部门" id="checkDep">|<input type="button" value="面向员工" id="checkEmp"></legend>
            <div>
                <c:if test="${sessionScope.type=='dep'}">
                    <div id="dep">
                        <c:if test="${sessionScope.departments==null}">
                            <c:out value="还没有建立部门"/>
                        </c:if>
                        <c:forEach items="${sessionScope.departments}" var="dep">
                            <p><input type="checkbox" value="${dep.id}">${dep.name}</p>
                        </c:forEach>
                        <span>
                            <input type="button" value="发布" class="fixed" id="depfix">
                            <input type="hidden" value="${sessionScope.tid}" class="tid">
                            <input type="button" value="取消" class="cancelTrain">
                        </span>
                    </div>
                </c:if>
                <div>
                    <c:if test="${sessionScope.type=='emp'}">
                        <div id="emp">
                            <c:if test="${sessionScope.employees==null}">
                                <c:out value="还没有员工入职"/>
                            </c:if>
                            <c:forEach items="${sessionScope.employees}" var="emp">
                                <p><input type="checkbox" value="${emp.id}">${emp.resume.name}</p>
                            </c:forEach>
                            <span>
                                <input type="button" value="发布" class="fixed" id="empfix">
                                <input type="hidden" value="${sessionScope.tid}" class="tid">
                                <input type="button" value="取消" class="cancelTrain">
                            </span>
                        </div>
                    </c:if>
                </div>
            </div>
        </fieldset>

    </div>
</div>
</body>
</html>
