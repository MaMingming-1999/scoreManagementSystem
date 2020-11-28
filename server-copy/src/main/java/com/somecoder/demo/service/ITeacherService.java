package com.somecoder.demo.service;

import com.somecoder.demo.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

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

    void updatetphone(UpdatetphoneRequest updatetphoneRequest);

    void updatetemail(UpdatetemailRequest updatetemailRequest);
}
