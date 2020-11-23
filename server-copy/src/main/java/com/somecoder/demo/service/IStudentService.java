package com.somecoder.demo.service;

import com.somecoder.demo.entity.LoginRequest;
import com.somecoder.demo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.somecoder.demo.entity.StudentInforRequest;
import com.somecoder.demo.entity.UpdatePasswdRequest;

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
}
