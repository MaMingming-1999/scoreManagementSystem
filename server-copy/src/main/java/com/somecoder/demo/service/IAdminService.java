package com.somecoder.demo.service;

import com.somecoder.demo.entity.LoginRequest;
import com.somecoder.demo.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
public interface IAdminService extends IService<Admin> {

    void adminlogin(LoginRequest loginRequest);

}
