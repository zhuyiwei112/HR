$(function () {
    $(":button").click(function () {
        $.ajax({
            type:"post",
            url:"register",
            data:"name="+$("#name").val()+"&pass="+$("#pass").val()+"&repass="+$("#repass").val(),
            success:function (obj) {
                alert(obj);
                if (obj=="注册成功") {
                    location.href = "gologin";
                }
            }
        })
    })
})