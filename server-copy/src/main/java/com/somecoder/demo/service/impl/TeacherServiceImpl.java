package com.somecoder.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.CourseMapper;
import com.somecoder.demo.mapper.TeacherMapper;
import com.somecoder.demo.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public void teacherlogin(LoginRequest loginRequest) {
        Teacher teacherlogin = teacherMapper.selectOne(
                Wrappers.lambdaQuery(Teacher.class)
                        .eq(Teacher::getTid,loginRequest.getSid())
                        .eq(Teacher::getTpassword,loginRequest.getSpassword())
        );
        if (Objects.isNull(teacherlogin)) {
            throw new BizException("用户名或密码错误");
        }

        //用户登陆成功，
    }


    @Override
    public void updatePassword(UpdatePasswdRequest updatePasswdRequest) {
        Teacher teacher = new Teacher();
        teacher.setTpassword(updatePasswdRequest.getNewPasswd());
        int count = teacherMapper.update(
                teacher,
                Wrappers.lambdaQuery(Teacher.class)
                        .eq(Teacher::getTid,updatePasswdRequest.getLoginId())
                        .eq(Teacher::getTpassword, updatePasswdRequest.getOldPasswd())
        );
        if (count == 0) {
            throw new BizException("原密码输入错误!");
        }
    }

    @Override
    public void insertteacher(TeacherRequest teacherrequest) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherrequest,teacher);
//        Student student = new Student();
//        student.setAid(studentcourse.getAid());
        teacherMapper.insert(teacher);
    }

    @Override
    public void updatetphone(UpdatetphoneRequest updatetphoneRequest) {
        Teacher teacher = new Teacher();
        teacher.setTphone(updatetphoneRequest.getTphone());
        teacherMapper.update(
                teacher,
                Wrappers.lambdaUpdate(Teacher.class)
                        .eq(Teacher::getTid,updatetphoneRequest.getTid())
        );
    }

    @Override
    public void updatetemail(UpdatetemailRequest updatetemailRequest) {
        Teacher teacher = new Teacher();
        teacher.setTemail(updatetemailRequest.getTemail());
        teacherMapper.update(
                teacher,
                Wrappers.lambdaUpdate(Teacher.class)
                        .eq(Teacher::getTid,updatetemailRequest.getId())
        );
    }
}
