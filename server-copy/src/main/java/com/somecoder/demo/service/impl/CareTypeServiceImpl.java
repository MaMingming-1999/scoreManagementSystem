package com.somecoder.demo.service.impl;

import com.somecoder.demo.entity.CareType;
import com.somecoder.demo.mapper.CareTypeMapper;
import com.somecoder.demo.service.ICareTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关注问题类型表 服务实现类
 * </p>
 *
 * @author somecoder
 * @since 2020-03-28
 */
@Service
public class CareTypeServiceImpl extends ServiceImpl<CareTypeMapper, CareType> implements ICareTypeService {

}
