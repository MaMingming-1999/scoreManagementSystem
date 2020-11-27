package com.somecoder.demo.service;

import com.somecoder.demo.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.somecoder.demo.entity.UpdatescoreRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
public interface IScoreService extends IService<Score> {
    void updatescore(UpdatescoreRequest updatescoreRequest);
}
