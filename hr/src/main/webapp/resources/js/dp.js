$(function () {

    //查询部门职位下的员工
    function paging(cp){
        var divpage=$("#divpage");
        divpage.empty();
        var table1=$("#table1");
        table1.empty();
        $(".page").remove();
        /*$(":button").css("display","none");
        $("#getEmp").css("display","block");*/
        var dname=$("#dep");
        var pname=$("#pos");
        $.ajax({
            type:"post",
            url:"getEmp",
            data:"dname="+dname.val()+"&pname="+pname.val()+"&cp="+cp,
            success:function (obj) {
                for (var index in obj[0]) {
                    var emp=obj[0][index];
                    var tr1=$("<tr id='tr1'></tr>");
                    table1.append(tr1);
                    var tdname=$("<td>姓名</td>");
                    var tdsex=$("<td>性别</td>");
                    var tdphone=$("<td>手机</td>");
                    var tdaddress=$("<td>地址</td>");
                    var tdemail=$("<td>邮箱</td>");
                    var tdempstate=$("<td>状态</td>");
                    tr1.append(tdname);
                    tr1.append(tdsex);
                    tr1.append(tdphone);
                    tr1.append(tdaddress);
                    tr1.append(tdemail);
                    tr1.append(tdempstate);
                    var tr2=$("<tr></tr>");
                    tr1.after(tr2);
                    var ename=$("<td></td>");
                    var esex=$("<td></td>");
                    var ephone=$("<td></td>");
                    var eaddress=$("<td></td>");
                    var eemail=$("<td></td>");
                    var empstate=$("<td></td>");
                    tr2.append(ename);
                    tr2.append(esex);
                    tr2.append(ephone);
                    tr2.append(eaddress);
                    tr2.append(eemail);
                    tr2.append(empstate);
                    ename.text(emp.resume.name);
                    esex.text(emp.resume.sex);
                    ephone.text(emp.resume.phone);
                    eaddress.text(emp.resume.address);
                    eemail.text(emp.resume.email);
                    empstate.text(emp.empState.state);
                }

                for (var i=1;i<=obj[1];i++) {
                    var but=$("<input type='button' class='page'>");
                    but.val(i);
                    divpage.after(but);
                }
                $(".page").click(function () {
                    var fy=$(this);
                    paging(fy.val());
                })
                /* var close=$("<input type='button' id='close' value='关闭'>");
                 $("#div1").append(close);
                 $("#close").click(function () {
                     location.reload(true);
                 })*/
            }
        })
    }
    $("#getEmp").click(function () {
        paging(1);
    })

    //修改职位
    $("#updatePos").click(function () {
        $(":button").css("display","none");
        var p1=$("#p1");
        var from=$("<from></from>");
        p1.before(from);
        var updatePos=$("<input placeholder='请输入修改内容'>");
        var notarize=$("<input type='button' value='确认'>");
        var cancel=$("<input type='button' value='取消'>");
        from.append(updatePos);
        from.append(notarize);
        from.append(cancel);
        var pname=$("#pos");
        updatePos.val(pname.val());
        var dname=$("#dep");

        notarize.click(function () {
            $.ajax({
                type:"post",
                url:"updatePos",
                data:"dname="+dname.val()+"&pname="+pname.val(),
                success:function (obj) {
                    alert(obj);
                    if (obj=="修改成功"){
                        location.reload(true);
                    }
                }
            })
        })

        cancel.click(function () {
            from.remove();
            location.reload(true);
        })

    })

    //返回部门信息
    $("#return").click(function () {
        location.href="godep";
    })
    //删除职位
    $("#delPos").click(function () {
        var delPos=$(this);
        var pos=delPos.prev();
        var dep=pos.prev();
        $.ajax({
            type:"post",
            url:"delPos",
            data:"pname="+pos.val()+"&dname="+dep.val(),
            success:function (obj) {
                alert(obj);
                if (obj=="删除成功") {
                    location.reload(true);
                }
            }
        })
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
})