$(function () {
    //跳转简历
    $("#updateRS").click(function () {
        location.href='goUpdateRS';
    })

    //删除简历
    $("#delRS").click(function () {
        var id=$("#rsid").val();
        $.ajax({
            type:"post",
            url:"delRS",
            data:"id="+id,
            success:function (obj) {
                alert(obj);
                if (obj=="删除成功"){
                    location.reload(true);
                }
            }
        })
    })

    //保存简历
    $("#addRS").click(function () {
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
            url:"addRS",
            data:"name="+name+"&birth="+birth+"&address="+address+
                "&education="+education+"&sex="+sex+"&phone="+phone+
                "&major="+major+"&email="+email+"&experience="+experience,
            success:function (obj) {
                alert(obj);
                if (obj=="保存成功"){
                    location.href='getRS';
                }
            }
        })
    })

    //关闭填写简历
    $("#close").click(function () {
        location.href='gologin';
    })
})