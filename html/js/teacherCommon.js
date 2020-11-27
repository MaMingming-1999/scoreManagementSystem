//获取变量
var id = JSON.parse(localStorage.getItem('teacher')).tid;
var tname = JSON.parse(localStorage.getItem('teacher')).tname;

//显示用户名
$(function () {
    $('#showUserName').text(tname);
})
//修改密码
function changePassword(){
    if($("#teacherPassword2").val()!==$("#teacherPassword1").val()){
        alert("两次新密码输入不一致！请重新输入！")
        return;
    }
    else if($("#teacherPassword2").val()==='' || $("#teacherPassword1").val()===''|| $("#teacherAccount").val()==='' || $("#teacherPassord").val()===''){
        alert("信息不能为空！")
        return;
    }
    else{
        //调取信息接口
        $.ajax({
            //接口地址
            url:'http://localhost:8001/demo/teacher/update/password',
            //请求方式post/get
            type:'post',
            contentType:'application/json',
            //数据
            data:JSON.stringify({
                loginId:$("#teacherAccount").val(),
                newPasswd:$("#teacherPassword2").val(),
                oldPasswd:$("#teacherPassword").val(),
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
                    alert("修改密码成功！");
                    window.location.href='../common/loginTeacher.html'
                }

            },
            //失败的回调函数
            error:function (e) {
                console.log(e);
            }
        })
    }
}

//返回登录页
function returnLogin(){
    window.location.href = "../common/loginTeacher.html"
}

//退出登录
function exitLogin(){
    window.location.href='../common/loginTeacher.html'
}
