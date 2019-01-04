<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 14:04
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
    <title>培训草稿</title>
    <script src="resources/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            //保存培训
            $("#save").click(function () {
                var request=$("#request").val();
                var beginTime=$("#beginTime").val();
                var endTime=$("#endTime").val();
                var content=$("#content").val();
                /*alert(request)
                alert(beginTime)
                alert(endTime)
                alert(content)*/
                $.ajax({
                    type:"post",
                    url:"addTrain",
                    data:"request="+request+"&beginTime="+beginTime+"&endTime="+endTime+"&content="+content,
                    success:function (obj) {
                        alert(obj);
                        if (obj=="保存成功") {
                            location.href='getTrain?type=1';
                        }
                    }
                })
            })

            //关闭
            $("#close").click(function () {
                if (confirm("未保存，是否离开")) {
                    location.href = 'getTrain?type=1';
                }
            })
        })
    </script>
</head>
<body>
<div>
    <div>
        <table>
            <tr>
                <td>培训主题：</td>
                <td><input id="request"></td>
            </tr>
            <tr>
                <td>开始时间：</td>
                <td><input type="date" id="beginTime"></td>
            </tr>
            <tr>
                <td>结束时间：</td>
                <td><input type="date" id="endTime"></td>
            </tr>
            <tr>
                <td>培训内容：</td>
                <td><textarea id="content" style="font-family: 楷体"></textarea></td>
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
