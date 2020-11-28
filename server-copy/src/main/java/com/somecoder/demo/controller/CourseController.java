package com.somecoder.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.CourseMapper;
import com.somecoder.demo.mapper.ScoreMapper;
import com.somecoder.demo.service.ICourseService;
import com.somecoder.demo.service.IScoreService;
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
@RequestMapping("/demo/course")
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Resource
    ICourseService courseService;

    @Resource
    CourseMapper courseMapper;

    @ApiOperation(value = "返回学生课程", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/returncourse")
    public ApiResponse<List<Course>> getPersonalInformation(
            @RequestBody CommonIdRequest commonIdRequest
    ) {
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseMapper.selectList(
                    Wrappers.lambdaQuery(Course.class)
                            .eq(Course::getSid,commonIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(courses);
    }

    @ApiOperation(value = "返回教师课程", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/returnTcourse")
    public ApiResponse<List<Course>> getteachercourse(
            @RequestBody CommonIdRequest commonIdRequest
    ) {
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseMapper.selectList(
                    Wrappers.lambdaQuery(Course.class)
                            .eq(Course::getTid,commonIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(courses);
    }

    @ApiOperation(value = "导入学生课程", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/students/course")
    public ApiResponse studentcourse(
            @RequestBody StudentRequest studentcourse
    ) {
        try {
            courseService.insertcourse(studentcourse);
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }

    @ApiOperation(value = "返回课程（管理员）", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/return/Cinfo")
    public ApiResponse<List<Course>> getCOURSE(
            @RequestBody AIdRequest aIdRequest
    ) {
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseMapper.selectList(
                    Wrappers.lambdaQuery(Course.class)
                            .eq(Course::getAid,aIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(courses);
    }

    @ApiOperation(value = "修改课程开设学院", tags = {CommonConstant.LOGIN_USER})
    @PostMapping(value = "/update/ccollege")
    public ApiResponse updateccollege(
            @RequestBody @Validated UpdateccollegeRequest updateccollegeRequest
    ) {
        try {
            courseService.updateccollege(updateccollegeRequest);
        }
        catch (BizException e) {
            logger.error("修改开设学院异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("修改开设学院异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success();
    }
}
