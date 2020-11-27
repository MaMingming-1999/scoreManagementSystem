package com.somecoder.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.StudentMapper;
import com.somecoder.demo.service.IStudentService;
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
@RequestMapping("/demo/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    IStudentService studentService;

    @Resource
    StudentMapper studentMapper;

    @ApiOperation(value = "学生登陆", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/login")
    public ApiResponse login(
            @RequestBody LoginRequest loginRequest
    ) {
        Student sid = new Student();
        try {
            sid = studentMapper.selectOne(
                    Wrappers.lambdaQuery(Student.class)
                            .eq(Student::getSid,loginRequest.getSid()));
            studentService.studentlogin(loginRequest);
        } catch (BizException e) {
            logger.error("登陆失败，错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("登陆失败，错误信息：", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(sid);
    }


    @ApiOperation(value = "返回学生信息（管理员）", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/returnTinfor")
    public ApiResponse<List<Student>> getinforT(
            @RequestBody AIdRequest aIdRequest
    ) {
        List<Student> students = new ArrayList<>();
        try {
            students = studentMapper.selectList(
                    Wrappers.lambdaQuery(Student.class)
                            .eq(Student::getAid,aIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(students);
    }


    @ApiOperation(value = "返回学生基本信息", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/return")
    public ApiResponse<Student> getPersonalInformation(
            @RequestBody CommonIdRequest commonIdRequest
    ) {
        Student student = new Student();
        try {
            student = studentMapper.selectOne(
                    Wrappers.lambdaQuery(Student.class)
                            .eq(Student::getSid,commonIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(student);
    }

    @ApiOperation(value = "修改学生密码", tags = {CommonConstant.LOGIN_USER})
    @PostMapping(value = "/update/password")
    public ApiResponse updatePassword(
            @RequestBody @Validated UpdatePasswdRequest updatePasswdRequest
    ) {
        try {
            studentService.updatePassword(updatePasswdRequest);
        }
        catch (BizException e) {
            logger.error("更新学生密码异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("更新学生密码异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }

    @ApiOperation(value = "导入学生信息", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/student/infor")
    public ApiResponse instudentinfor(
            @RequestBody StudentInforRequest studentrequest
    ) {
        try {
            studentService.insertstudent(studentrequest);
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }
}
