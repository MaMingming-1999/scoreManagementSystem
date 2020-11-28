package com.somecoder.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.somecoder.demo.entity.*;
import com.somecoder.demo.mapper.CourseMapper;
import com.somecoder.demo.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Resource
    CourseMapper courseMapper;

    @Override
    public void insertcourse(StudentRequest studentcourse) {
        Course course = new Course();
        BeanUtils.copyProperties(studentcourse,course);
//        Student student = new Student();
//        student.setAid(studentcourse.getAid());
        courseMapper.insert(course);
    }


    @Override
    public void updateccollege(UpdateccollegeRequest updateccollegeRequest) {
        Course course = new Course();
        course.setCcollege(updateccollegeRequest.getCcollege());
        courseMapper.update(
                course,
                Wrappers.lambdaUpdate(Course.class)
                        .eq(Course::getCid,updateccollegeRequest.getCid())
        );
    }
}
