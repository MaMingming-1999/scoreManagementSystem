//获取变量
var id = JSON.parse(localStorage.getItem('student')).sid;
var sname = JSON.parse(localStorage.getItem('student')).sname;

//显示用户名
$(function () {
    $('#showUserName').text(sname);
})

//退出登录
function exitLogin(){
    window.location.href='../common/loginStudent.html'
}

//返回学生基本信息
$(function () {
    //调取信息接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/student/return',
        //请求方式post/get
        type:'post',
        contentType:'application/json',
        //数据
        data:JSON.stringify({
            id: id,
        }),
        //返回值类型
        dataType:'json',
        //成功的回调函数
        success:function (data) {
            if(data.code===1)
            {
                alert(data.msg);
                console.log(data);
            } else {
                document.getElementById('studentId').value = data.data.sid;
                document.getElementById('studentName').value = data.data.name;
                document.getElementById('studentCollege').value = data.data.scollege;
                document.getElementById('studentMajor').value = data.data.smajor;
                document.getElementById('studentPhone').value = data.data.sphone;
                document.getElementById('studentEmail').value = data.data.semail;
                document.getElementById('studentYear').value = data.data.syear;
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
})
