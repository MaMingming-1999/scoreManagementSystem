package com.somecoder.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.controller.CourseController;
import com.somecoder.demo.controller.StudentController;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.StudentMapper;
import com.somecoder.demo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    StudentMapper studentMapper;

    public void studentlogin(LoginRequest loginRequest) {
        Student studentlogin = studentMapper.selectOne(
                Wrappers.lambdaQuery(Student.class)
                        .eq(Student::getSid, loginRequest.getSid())
                        .eq(Student::getSpassword, loginRequest.getSpassword())
        );

        if (Objects.isNull(studentlogin)) {
            throw new BizException("用户名或密码错误");
        }

        //用户登陆成功，
    }

    @Override
    public void updatePassword(UpdatePasswdRequest updatePasswdRequest) {
        Student student = new Student();
        student.setSpassword(updatePasswdRequest.getNewPasswd());
        int count = studentMapper.update(
                student,
                Wrappers.lambdaUpdate(Student.class)
                        .eq(Student::getSid,updatePasswdRequest.getLoginId())
                        .eq(Student::getSpassword, updatePasswdRequest.getOldPasswd())
        );
        if (count == 0) {
            throw new BizException("原密码输入错误!");
        }
    }

    @Override
    public void insertstudent(StudentInforRequest studentrequest) {
        Student student = new Student();
        BeanUtils.copyProperties(studentrequest,student);
//        Student student = new Student();
//        student.setAid(studentcourse.getAid());
        studentMapper.insert(student);
    }

    @Override
    public void updatesyear(UpdatesyearRequest updatesyearRequest) {
        Student student = new Student();
        student.setSyear(updatesyearRequest.getSyear());
        studentMapper.update(
                student,
                Wrappers.lambdaUpdate(Student.class)
                        .eq(Student::getSid,updatesyearRequest.getSid())
        );
    }
}

