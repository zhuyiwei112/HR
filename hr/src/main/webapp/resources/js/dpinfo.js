$(function () {

    //查询职位
    $("#bps2").click(function () {
        location.href="getDep";
    })
    /*var getPos=$(".getPos");
    getPos.click(function () {
        //div2.css("display","block");
        getPos.css("display","none");
        var id=$(this).parent().prev().prev().prev().prev().prev().prev();
        $.ajax({
            type:"post",
            url:"getPosition",
            data:"id="+id.val(),
            success:function (obj) {
                location.href="getPosition";
            }
        })
    })*/

    //button的控制
    //查询职位按钮
    /*$("#bps2").click(function () {
        /!*$(":button").attr("disabled",true);
        var bps2=$(this);
        bps2.attr("value","　取消　");
        bps2.attr("disabled",false);*!/
        var div1=$("#div1");
        div1.css("display","none");
        var getPos=$(".getPos");
        getPos.css("display","block");
        /!*getPos.attr("disabled",false);*!/
        var close=$("<input type='button' value='　关闭　'>");
        div1.after(close);
        close.click(function () {
            location.reload(true);
        })
    })*/
    //删除部门显示
    $("#bdp1").click(function () {
        $(":button").attr("disabled",true);
        var bdp1=$(this);
        bdp1.attr("disabled",false);
        bdp1.attr("value","　取消　");
        var delDep=$(".delDep");
        delDep.css("display","block");
        delDep.attr("disabled",false);
        bdp1.click(function () {
            location.reload(true);
        })
    })
    //修改部门显示
    $("#bdp2").click(function () {
        $(":button").attr("disabled",true);
        var bdp2=$(this);
        bdp2.attr("disabled",false);
        bdp2.attr("value","　取消　");
        var updateDep=$(".updateDep");
        updateDep.css("display","block");
        updateDep.attr("disabled",false);
        bdp2.click(function () {
            location.reload(true);
        })
    })
    //职位增加显示
    $("#bps1").click(function () {
        $(":button").attr("disabled",true);
        var bps1=$(this);
        bps1.attr("value","　取消　");
        bps1.attr("disabled",false);
        var addPos=$(".addPos");
        addPos.css("display","block");
        addPos.attr("disabled",false);
        bps1.click(function () {
            location.reload(true);
        })
    })


    //部门修改
    $(".updateDep").click(function () {
        var id=$(this).parent().prev().prev().prev().prev().prev();
        var dname=id.next().text();
        $(".updateDep").attr("disabled",true);
        var div1=$("#div1");
        var from=$("<form></from>");
        div1.after(from);
        var update=$("<input placeholder='请输入修改的内容'>");
        update.val(dname);
        var button=$("<input type='button' value='确认'>");
        var cancel=$("<input type='button' value='取消'>");
        from.append(update);
        from.append(button);
        from.append(cancel);
        button.click(function () {
            $.ajax({
                type:"post",
                url:"updateDep",
                data:"name="+update.val()+"&id="+id.val(),
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

    //职位增加
    $(".addPos").click(function () {
        var did=$(this).parent().prev().prev().prev().prev();
        var inp=$("#addDep");
        var div1=$("#div1");
        inp.attr("disabled",true);
        $(".delDep").attr("disabled",true);
        $(".addPos").attr("disabled",true);
        var from=$("<from action='addPos' method='post'></from>");
        div1.after(from);
        var addPos=$("<input placeholder='请输入新增职位' type='text' name='position'>");
        from.append(addPos);
        var button=$("<input type='button' id='but2' value='确认'>");
        from.append(button);
        var cancel=$("<input type='button' id='cancel' value='取消'>");
        from.append(cancel);
        $("#but2").click(function () {
            $.ajax({
                type:"post",
                url:"addPos",
                data:"name="+addPos.val()+"&did="+did.val(),
                success:function (obj) {
                    alert(obj);
                    if (obj=="添加成功"){
                        location.href='godep';
                    }
                }
            })
        })
        cancel.click(function () {
            from.remove();
            location.reload(true);
        })
    })

    //部门删除
    $(".delDep").click(function () {
        var id = $(this).parent().prev().prev().prev();
        $.ajax({
            type:"post",
            url:"delDep",
            data:"id="+id.val(),
            success:function (obj) {
                alert(obj);
                if (obj=="删除成功"){
                    location.href="godep";
                }
            }
        })
    })

    //部门增加
    $("#addDep").click(function () {
        $(":button").attr("disabled",true);
        var inp = $("#addDep");
        inp.attr("disabled",true);
        var form = $("<form action='addDep' method='post'></form>");
        $("#div1").after(form);
        var input = $("<input name='department' type='text' placeholder='请输入新增部门'>");
        form.append(input);
        var button = $("<input type='button' id='but1' value='确认'>");
        form.append(button);
        var cancel = $("<input type='button' id='cancel' value='取消'>");
        form.append(cancel);
        cancel.click(function () {
            form.remove();
            $(":button").attr("disabled",false);
        })
        button.click(function () {
            $.ajax({
                type: "post",
                url: "adddep",
                data: "department=" +input.val(),
                success: function (obj) {
                    alert(obj);
                    if (obj == "添加成功") {
                        location.href = "godep";
                    }
                }
            })
        })
    })
})