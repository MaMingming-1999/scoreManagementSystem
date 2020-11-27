package com.somecoder.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.common.exception.BizException;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.ScoreMapper;
import com.somecoder.demo.mapper.StudentMapper;
import com.somecoder.demo.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Resource
    ScoreMapper scoreMapper;

    @Override
    public void updatescore(UpdatescoreRequest updatescoreRequest) {
        Score score = new Score();

        scoreMapper.update(
                score,
                Wrappers.lambdaUpdate(Score.class)
                        .eq(Score::getSid,updatescoreRequest.getSid())
                        .eq(Score::getCid,updatescoreRequest.getCid())
                        .eq(Score::getSpercent, updatescoreRequest.getSpercent())
        );
    }
}
