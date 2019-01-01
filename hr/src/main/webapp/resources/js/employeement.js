$(function () {

    //删除招聘
    $(".delRC").click(function () {
        var del=$(this);
        var id=del.prev();
        var pid=del.next();
        if (confirm("是否删除")){
            $.ajax({
                type:"post",
                url:"delRC",
                data:"id="+id.val()+"&pid="+pid.val(),
                success:function (obj) {
                    alert(obj);
                    if (obj=="删除成功"){
                        location.reload(true);
                    }
                }

            })
        }
    })

    //发布or撤销
    var publishRC=$(".publishRC");
    publishRC.click(function () {
        var publish=$(this);
        var id=publish.next();
        var pid=id.next().next();
        var did=pid.next();
        if (publish.val()=="发布"){
            if (confirm("是否发布")){
                publish.val("撤销");
                $.ajax({
                    type:"post",
                    url:"publishRC",
                    data:"id="+id.val()+"&publish="+"发布"+"&pid="+pid.val(),
                    success:function (obj) {
                        alert(obj);
                        if(obj=="发布成功") {
                            location.reload(true);
                        }
                    }
                })
            }
        }else {
            if(publish.val()=="撤销"){
                if (confirm("是否撤销")){
                    publish.val("发布");
                    $.ajax({
                        type:"post",
                        url:"publishRC",
                        data:"id="+id.val()+"&publish="+"撤销"+"&pid="+pid.val(),
                        success:function (obj) {
                            alert(obj);
                            if (obj=="撤销成功"){
                                location.reload(true);
                            }
                        }
                    })
                }
            }
        }
    })

    //查看招聘
    $("#checkRC").click(function () {
        var rcinfo=$("#rcinfo");
        rcinfo.show();
        $.ajax({
            type:"post",
            url:"getRC",
            data:"dname="+$("#dep").val()+"&pname="+$("#pos").val(),
            success:function () {
            }
        })
    });
    //查看详情
    var checkRCdetail=$(".checkRCdetail");
    checkRCdetail.click(function () {
        var checkbut = $(this);
        var detRC = checkbut.parent().parent().parent().parent().next();

        if (checkbut.val()=="查看") {
            checkbut.val("关闭");
            detRC.show();
        }else {
            checkbut.val("查看");
            detRC.hide();
        }
    })

    //二级联动
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

//新增招聘
    $("#draftRC").click(function () {
        location.href='goaddRC?dname='+$("#dep").val()+"&pname="+$("#pos").val();
    })
})