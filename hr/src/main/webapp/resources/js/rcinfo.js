$(function () {
    $(".notEmptyTime").click(function () {
        var checkdetail=$(this);
        var divdetail=checkdetail.parent().parent().parent().parent().next();
        if (checkdetail.val()=="查看"){
            checkdetail.val("关闭");
            divdetail.show();
        }else {
            checkdetail.val("查看");
            divdetail.hide();
        }
    })
})