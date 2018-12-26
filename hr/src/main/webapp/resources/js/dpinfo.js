$(function () {
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

    $("#addDep").click(function () {
        var inp = $("#addDep");
        inp.attr("disabled",true);
        var form = $("<form action='addDep' method='post'></form>");
        inp.after(form);
        var input = $("<input name='department' type='text' placeholder='请输入新增的部门名称'>");
        form.append(input);
        var button = $("<input type='button' id='but1' value='确认'>");
        form.append(button);
        var cancel = $("<input type='button' id='cancel' value='取消'>");
        form.append(cancel);
        cancel.click(function () {
            form.remove();
            inp.attr("disabled",false);
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