package com.somecoder.demo.service.impl;

import com.somecoder.demo.entity.Score;
import com.somecoder.demo.mapper.ScoreMapper;
import com.somecoder.demo.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
