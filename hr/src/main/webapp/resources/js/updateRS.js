$(function () {
//关闭修改按钮
    $("#close").click(function () {
        location.href='getRS';
    })
    //保存按钮
    $("#updateRS").click(function () {
        var name=$("#rsname").val();
        var birth=$("#rsbirth").val();
        var address=$("#rsaddress").val();
        var education=$("#rsedu").val();
        var sex=$("#rssex").val();
        var phone=$("#rsphone").val();
        var major=$("#rsmajor").val();
        var email=$("#rsmail").val();
        var experience=$("#rsexper").val();
        $.ajax({
            type:"post",
            url:"updateRS",
            data:"name="+name+"&birth="+birth+"&address="+address+
                "&education="+education+"&sex="+sex+"&phone="+phone+
                "&major="+major+"&email="+email+"&experience="+experience,
            success:function (obj) {
                alert(obj);
                if (obj=="修改成功"){
                    location.href='getRS';
                }
            }
        })
    })
})