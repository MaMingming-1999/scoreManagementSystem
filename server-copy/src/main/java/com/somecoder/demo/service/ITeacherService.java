package com.somecoder.demo.service;

import com.somecoder.demo.entity.LoginRequest;
import com.somecoder.demo.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.somecoder.demo.entity.TeacherRequest;
import com.somecoder.demo.entity.UpdatePasswdRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
public interface ITeacherService extends IService<Teacher> {
    void teacherlogin(LoginRequest loginRequest);

    void updatePassword(UpdatePasswdRequest updatePasswdRequest);

    void insertteacher(TeacherRequest teacherrequest);
}
