package com.somecoder.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.TeacherMapper;
import com.somecoder.demo.service.ITeacherService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/demo/teacher")
public class TeacherController {

    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Resource
    ITeacherService teacherService;

    @Resource
    TeacherMapper teacherMapper;

    @ApiOperation(value = "普通教师登陆", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/login")
    public ApiResponse login(
            @RequestBody LoginRequest loginRequest
    ) {
        Teacher tid = new Teacher();
        try {
            tid = teacherMapper.selectOne(
                    Wrappers.lambdaQuery(Teacher.class)
                            .eq(Teacher::getTid,loginRequest.getSid()));
            teacherService.teacherlogin(loginRequest);
        } catch (BizException e) {
            logger.error("登陆失败，错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("登陆失败，错误信息：", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(tid);
    }

    @ApiOperation(value = "修改老师密码", tags = {CommonConstant.LOGIN_USER})
    @PostMapping(value = "/update/password")
    public ApiResponse updatePassword(
            @RequestBody @Validated UpdatePasswdRequest updatePasswdRequest
    ) {
        try {
            teacherService.updatePassword(updatePasswdRequest);
        }
        catch (BizException e) {
            logger.error("更新老师密码异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("更新老师密码异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }

    @ApiOperation(value = "导入教师信息", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/teacher/infor")
    public ApiResponse inteacherinfor(
            @RequestBody TeacherRequest teacherrequest
    ) {
        try {
            teacherService.insertteacher(teacherrequest);
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }


    @ApiOperation(value = "返回教师信息（管理员）", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/return/Tinfo")
    public ApiResponse<List<Teacher>> getinfoT(
            @RequestBody AIdRequest aIdRequest
    ) {
        List<Teacher> teachers = new ArrayList<>();
        try {
            teachers = teacherMapper.selectList(
                    Wrappers.lambdaQuery(Teacher.class)
                            .eq(Teacher::getAid,aIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(teachers);
    }

    @ApiOperation(value = "修改老师手机号", tags = {CommonConstant.LOGIN_USER})
    @PostMapping(value = "/update/tphone")
    public ApiResponse updatetphone(
            @RequestBody @Validated UpdatetphoneRequest updatetphoneRequest
    ) {
        try {
            teacherService.updatetphone(updatetphoneRequest);
        }
        catch (BizException e) {
            logger.error("更新老师手机号异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("更新老师手机号异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }

    @ApiOperation(value = "修改老师邮箱", tags = {CommonConstant.LOGIN_USER})
     @PostMapping(value = "/update/temail")
    public ApiResponse updatetemail(
            @RequestBody @Validated UpdatetemailRequest updatetemailRequest
    ) {
        try {
            teacherService.updatetemail(updatetemailRequest);
        }
        catch (BizException e) {
            logger.error("更新学生成绩异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("更新学生成绩异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }
}