package com.somecoder.demo.controller;


import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.LoginRequest;
import com.somecoder.demo.entity.Student;
import com.somecoder.demo.entity.Teacher;
import com.somecoder.demo.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
@RestController
@CrossOrigin
@RequestMapping("/demo/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    IAdminService adminService;

    @ApiOperation(value = "管理员登陆", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/login")
    public ApiResponse login(
            @RequestBody LoginRequest loginRequest
    ) {
        try {
            adminService.adminlogin(loginRequest);
        } catch (BizException e) {
            logger.error("登陆失败，错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("登陆失败，错误信息：", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }
}
