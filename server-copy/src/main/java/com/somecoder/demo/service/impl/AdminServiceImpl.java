package com.somecoder.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.LoginRequest;
import com.somecoder.demo.entity.Admin;
import com.somecoder.demo.mapper.AdminMapper;
import com.somecoder.demo.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public void adminlogin(LoginRequest loginRequest) {
        Admin adminlogin = adminMapper.selectOne(
                Wrappers.lambdaQuery(Admin.class)
                        .eq(Admin::getAid,loginRequest.getSid())
                        .eq(Admin::getApassword,loginRequest.getSpassword())
        );

        if (Objects.isNull(adminlogin)) {
            throw new BizException("用户名或密码错误");
        }

        //用户登陆成功，
    }
}
