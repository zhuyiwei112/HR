<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28
  Time: 15:12
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
    <script src="resources/js/addRC"></script>
    <script>
        $(function () {
            var save=$("#save");
            save.click(function () {
                var theme=$("#theme").val();
                var request=$("#request").val();
                var content=$("#content").val();
                var number=$("#number").val();
               $.ajax({
                   type:"post",
                   url:"addRC",
                   data:"theme="+theme+"&request="+request+"&content="+content+"&number="+number,
                   success:function (obj) {
                       alert(obj);
                       if (obj=="保存成功"){
                           location.href='goRC';
                       }
                   }
               })
            });
            var close=$("#close");
            close.click(function () {
                location.href='goRC';
            })
        })
    </script>
</head>
<body>
<div>
    <div>
        <table>
            <tr>
                <td>招聘主题：</td>
                <td><input id="theme"></td>
            </tr>
            <tr>
                <td>所属部门：</td>
                <td><input readonly value="${sessionScope.dname}"></td>
            </tr>
            <tr>
                <td>所属职位：</td>
                <td><input readonly value="${sessionScope.pname}"></td>
            </tr>
            <tr>
                <td>招聘要求：</td>
                <td><input id="request"></td>
            </tr>
            <tr>
                <td>招聘内容：</td>
                <td><textarea id="content" style="font-family: 楷体"></textarea></td>
            </tr>
            <tr>
                <td>招聘人数：</td>
                <td><input id="number"></td>
            </tr>
        </table>
        <div>
            <input type="button" id="save" value="保存">
            <input type="button" id="close" value="关闭">
        </div>
    </div>
</div>
</body>
</html>
