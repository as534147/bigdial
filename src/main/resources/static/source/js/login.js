$(function(){
    $("#loginBtnId").click(function(){
        console.log("loginBtnId点击时间生效啦")

        var name = $("#nameUser").val();
        var code = $("#namePassword").val();
        if(!name){
            $("#remainMsg").html('请输入账号！');
            return;
        }
        if(!code){
            $("#remainMsg").html('请输入密码！');
            return;
        }
        var params = {
            "nameCode":name,
            "loginpassword":code
        }
        $.ajax({
            url:"/toLogin",
            data:JSON.stringify(params),
            dataType:'JSON',
            async: true,
            contentType : "application/json",
            async: false,
            type:'POST',
            success :function (result) {
                var respCode = result.respCode;
                var respDesc = result.respDesc;
                var result = result.result;
                console.log("登录的返回数据："+JSON.stringify(result));
                if(respCode==0){
                    if(result){
                        window.location.href = "/wheel";
                    }else{
                        window.location.href = "/wheel";
                    }
                }else{
                    $("#remainMsg").html('请重新输入！');
                }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            }
        })

    });
})