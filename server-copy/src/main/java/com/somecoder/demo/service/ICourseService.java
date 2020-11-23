package com.somecoder.demo.service;

import com.somecoder.demo.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.somecoder.demo.entity.StudentRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
public interface ICourseService extends IService<Course> {

    void insertcourse(StudentRequest studentcourse);
}
