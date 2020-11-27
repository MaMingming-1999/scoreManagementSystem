function loginBtnStudent(){
    var loginId = $('#studentAccount').val();//获取登陆名
    var password = $('#studentPassword').val();//获取登陆名
    if(loginId === ''||password === ''){
        alert('用户名或者密码为空，请输入后再次提交');
        return;
    }
    //调取登录接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/student/login',
        //请求方式post/get
        type:'post',
        contentType:'application/json',
        //数据
        data:JSON.stringify({
            sid:loginId,
            spassword:password,
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
                alert('欢迎您,'+data.data.name);
                var student = JSON.stringify({
                    sid : data.data.sid,
                    sname : data.data.name,
                })
                localStorage.setItem('student',student);
                window.location.href = "../student/index.html";
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })

}
function loginBtnTeacher(){
    var loginId = $('#teacherAccount').val();//获取登陆名
    var password = $('#teacherPassword').val();//获取登陆名
    if(loginId === ''||password === ''){
        alert('用户名或者密码为空，请输入后再次提交');
        return;
    }
    //调取登录接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/teacher/login',
        //请求方式post/get
        type:'post',
        contentType:'application/json',
        //数据
        data:JSON.stringify({
            sid:loginId,
            spassword:password,
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
                alert('欢迎您,'+ data.data.tname);
                var teacher = JSON.stringify({
                    tid : data.data.tid,
                    tname : data.data.tname,
                })
                localStorage.setItem('teacher',teacher);
                window.location.href = "../teacher/index.html"
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
}
function loginBtnAdmin(){
    var loginId1 = $('#adminAccount').val();//获取登陆名
    var password1 = $('#adminPassword').val();//获取登陆名
    if(loginId1 === ''||password1 === ''){
        alert('用户名或者密码为空，请输入后再次提交');
        return;
    }
    //调取登录接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/admin/login',
        //请求方式post/get
        type:'post',
        contentType:'application/json',
        //数据
        data:JSON.stringify({
            sid: loginId1,
            spassword: password1,
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
                alert('欢迎您');
                localStorage.setItem('aid',loginId1);
                window.location.href = "../teacherAdmin/index.html"
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
}
