<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 9:57
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
    <title>打卡</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <style>
        #clock{
            background-color: black;
            color: rgb(254,254,65);
            border: none;
            height: 80px;
            width: 200px;
            font-family: 楷体;
            font-size: 42px
        }
        p{
            margin: 10px;

        }
    </style>
    <script>
        $(function () {
            $("#checkon").click(function () {
                var time=$("#hide").val();
                $.ajax({
                    type:"post",
                    url:"addAttend",
                    data:"beginTime="+time,
                    success:function (obj) {
                        if (obj=="请登入"){
                            location.href='gologin';
                        }
                        location.href='goAttend';
                    }
                })
            })
            $("#checkoff").click(function () {
                var time=$("#hide").val();
                var adid=$("#adid").val();
                $.ajax({
                    type:"post",
                    url:"updateAttend",
                    data:"endTime="+time+"&adid="+adid,
                    success:function (obj) {
                        if (obj=="请登入"){
                            location.href='gologin';
                        }
                        location.href='goAttend';
                    }
                })
            })
        })
        //时钟
        $(function () {
            var input=$("#clock");
            setInterval(function () {
                var date = new Date();
                var hh = date.getHours();
                var mm = date.getMinutes();
                var ss = date.getSeconds();
                if (hh < 10) {
                    hh = "0" + hh;
                }
                if (mm < 10) {
                    mm = "0" + mm;
                }
                if (ss < 10) {
                    ss = "0" + ss;
                }
                var clock = hh + ":" + mm + ":" + ss;
                var clock1 = hh+":"+mm;
                $("#hide").val(clock1);
                input.val(clock);
            })
        },1000)
    </script>
</head>
<body>
<jsp:include page="employeeMain.jsp" flush="true"/>
<div>
    <fieldset>
        <legend>考勤打卡</legend>
        <div>
            <input type="hidden" value="${sessionScope.attendance.id}" id="adid">
            <input type="hidden" id="hide">
            <p><input id="clock" type="button"></p>
            <p style="color: grey">上班时间 09：00</p>
            <p>　
                <span>打卡时间 ${sessionScope.attendance.beginTime}</span>
                <c:if test="${empty sessionScope.attendance.beginTime}">
                    <span><input type="button" value="上班打卡" id="checkon"></span>
                </c:if>
                <%--<c:if test="${empty sessionScope.attendance.beginTime}">
                    <span><input type="button" value="上班打卡" class="checkon"></span>
                </c:if>--%>
            </p>
            <p style="color: gray">下班时间 18：00</p>
            <c:if test="${not empty sessionScope.attendance.beginTime}">
                <p>　
                    <span>打卡时间 ${sessionScope.attendance.endTime}</span>
                    <%--<c:if test="${empty sessionScope.attendance.endTime}">
                        <span><input type="button" value="下班打卡"></span>
                    </c:if>--%>
                    <%--<c:if test="${not empty sessionScope.attendance.endTime}"></c:if>--%>
                    <span><input type="button" value="下班打卡" id="checkoff"></span>

                </p>
            </c:if>
        </div>

    </fieldset>

    <div>


    </div>
</div>
</body>
</html>
