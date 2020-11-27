var aid = localStorage.getItem('aid');
//退出登录
function exitLogin(){
    window.location.href='../common/loginAdmin.html'
}
//导入学生课程（单个）
function submitEnterCourse(){
    //调取导入接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/course/students/course',
        //请求方式post/get
        type:'post',
        contentType:'application/json',

        //数据
        data:JSON.stringify({
            aid: "19991112",
            ccollege: $("#EnterCourseCollege").val(),
            cid: $("#EnterCourseCid").val(),
            cmajor: $("#EnterCourseMajor").val(),
            cname: $("#EnterCourseCname").val(),
            cyear: $("#EnterCourseYear").val(),
            sid: $("#EnterCourseSid").val(),
            tid: $("#EnterCourseTid").val()

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
                alert('导入成功！');
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
}
//导入学生信息（单个）
function submitEnterStudent(){
    //调取导入接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/student/student/infor',
        //请求方式post/get
        type:'post',
        contentType:'application/json',

        //数据
        data:JSON.stringify({
            aid: "19991112",
            name: $('#enterStudentName').val(),
            scollege: $('#enterStudentCollege').val(),
            semail: $('#enterStudentEmail').val(),
            sid: $('#enterStudentSid').val(),
            smajor: $('#enterStudentMajor').val(),
            spassword: $('#enterStudentPassword').val(),
            sphone: $('#enterStudentPhone').val(),
            syear: $('#enterStudentYear').val()
        }),
        //返回值类型
        dataType:'json',
        //成功的回调函数
        success:function (data) {
            if(data.msg === 'SUCCESS'){
                alert("导入成功！")
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
}

//导入老师信息（单个）
function submitEnterTeacher(){
    //调取导入接口
    $.ajax({
        //接口地址
        url:'http://localhost:8001/demo/teacher/teacher/infor',
        //请求方式post/get
        type:'post',
        contentType:'application/json',

        //数据
        data:JSON.stringify({
            aid: '19991112',
            tcollege: $('#enterTeacherCollege').val(),
            temail: $('#enterTeacherEmail').val(),
            tid: $('#enterTeacherId').val(),
            tname: $('#enterTeacherName').val(),
            tpassword: $('#enterTeacherPassword').val(),
            tphone: $('#enterTeacherPhone').val()
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
                alert('导入成功！');
            }

        },
        //失败的回调函数
        error:function (e) {
            console.log(e);
        }
    })
}
