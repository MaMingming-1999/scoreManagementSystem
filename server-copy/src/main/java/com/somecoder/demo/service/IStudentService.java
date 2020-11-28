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
public interface IStudentService extends IService<Student> {
    void studentlogin(LoginRequest loginRequest);


    void updatePassword(UpdatePasswdRequest updatePasswdRequest);

    void insertstudent(StudentInforRequest studentrequest);

    void updatesyear(UpdatesyearRequest updatesyearRequest);
}
