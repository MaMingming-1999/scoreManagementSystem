package com.somecoder.demo.service.impl;

import com.somecoder.demo.entity.CareStudent;
import com.somecoder.demo.mapper.CareStudentMapper;
import com.somecoder.demo.service.ICareStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 重点关注学生表，多对多 服务实现类
 * </p>
 *
 * @author somecoder
 * @since 2020-03-28
 */
@Service
public class CareStudentServiceImpl extends ServiceImpl<CareStudentMapper, CareStudent> implements ICareStudentService {

}
