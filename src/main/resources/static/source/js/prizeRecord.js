$(function(){
    var params = {
        "nameCode":"7010"
    }
    $.ajax({
        url:"/prize",
        data:JSON.stringify(params),
        dataType:'JSON',
        async: true,
        contentType : "application/json",
        async: false,
        type:'POST',
        success :function (data) {
            var respCode = data.respCode;
            var respDesc = data.respDesc;
            var result = data.result;
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth()+1;
            var day = date.getDate();
            var hour = date.getHours();
            var minu = date.getMinutes();
            var second = date.getSeconds();
            month = month<10?(0+""+month):month;
            day = day<10?(0+""+day):day;
            hour = hour<10?(0+""+hour):hour;
            minu = minu<10?(0+""+minu):minu;
            second = second<10?(0+""+second):second;
            if(result=="-1"){
                $("#prizeTime").html(year+"-"+month+"-"+day);
                $("#prizeMsg").html("无获奖信息！");
            }else if(respCode==0){
                $("#prizeTime").html(year+"-"+month+"-"+day);
                $("#prizeMsg").html(result.prizeName);
            }
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    })
})