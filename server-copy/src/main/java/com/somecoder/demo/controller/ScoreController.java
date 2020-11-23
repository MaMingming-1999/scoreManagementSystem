package com.somecoder.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.ApiResponse;
import com.somecoder.demo.common.CommonConstant;
import com.somecoder.demo.common.ErrorCodeEnum;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.CommonIdRequest;
import com.somecoder.demo.entity.Score;
import com.somecoder.demo.entity.Student;
import com.somecoder.demo.mapper.ScoreMapper;
import com.somecoder.demo.mapper.StudentMapper;
import com.somecoder.demo.service.IScoreService;
import com.somecoder.demo.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/demo/score")
public class ScoreController {

    Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Resource
    IScoreService scoreService;

    @Resource
    ScoreMapper scoreMapper;

    @ApiOperation(value = "返回学生成绩", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/returnscore")
    public ApiResponse<List<Score>> getPersonalInformation(
            @RequestBody CommonIdRequest commonIdRequest
    ) {
        List<Score> scores = new ArrayList<>();
        try {
            scores = scoreMapper.selectList(
                    Wrappers.lambdaQuery(Score.class)
                            .eq(Score::getSid,commonIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(scores);
    }


    @ApiOperation(value = "返回教师成绩", tags = {CommonConstant.USER_API_TAG})
    @PostMapping(value = "/returnTscore")
    public ApiResponse<List<Score>> getteacherscore(
            @RequestBody CommonIdRequest commonIdRequest
    ) {
        List<Score> scores = new ArrayList<>();
        try {
            scores = scoreMapper.selectList(
                    Wrappers.lambdaQuery(Score.class)
                            .eq(Score::getTid,commonIdRequest.getId())
            );
        } catch (BizException e) {
            logger.error("获取个人信息异常,错误信息:[{}]", e.getErrMessage());
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            logger.error("获取个人信息异常", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(scores);
    }

}
