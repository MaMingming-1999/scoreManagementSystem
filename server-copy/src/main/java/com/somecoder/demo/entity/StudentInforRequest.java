package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentInforRequest {
        @ApiModelProperty(value = "学号")
        @NotNull(message = "学号不能为空")
        @NotBlank(message = "学号不能为空")
        private String sid;

        @ApiModelProperty(value = "学生姓名")
        @NotNull(message = "姓名不能为空")
        @NotBlank(message = "姓名不能为空")
        private String name;

        @ApiModelProperty(value = "学生电话")
        @NotNull(message = "学院不能为空")
        @NotBlank(message = "学院不能为空")
        private String sphone;

        @ApiModelProperty(value = "学生密码")
        @NotNull(message = "专业不能为空")
        @NotBlank(message = "专业不能为空")
        private String spassword;

        @ApiModelProperty(value = "学生学院")
        @NotNull(message = "班级不能为空")
        @NotBlank(message = "班级不能为空")
        private String scollege;

        @ApiModelProperty(value = "学生专业")
        @NotNull(message = "课程名称不能为空")
        @NotBlank(message = "课程名称不能为空")
        private String smajor;

        @ApiModelProperty(value = "学生学年")
        @NotNull(message = "课程名称不能为空")
        @NotBlank(message = "课程名称不能为空")
        private String syear;

        @ApiModelProperty(value = "学生邮箱")
        @NotNull(message = "课程名称不能为空")
        @NotBlank(message = "课程名称不能为空")
        private String semail;

}