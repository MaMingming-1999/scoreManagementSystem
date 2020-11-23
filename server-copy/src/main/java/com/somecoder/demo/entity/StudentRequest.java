package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {
    @ApiModelProperty(value = "课程编号")
    @NotNull(message = "学号不能为空")
    @NotBlank(message = "学号不能为空")
    private String cid;

    @ApiModelProperty(value = "学号")
    @NotNull(message = "姓名不能为空")
    @NotBlank(message = "姓名不能为空")
    private String sid;

    @ApiModelProperty(value = "工号")
    @NotNull(message = "学院不能为空")
    @NotBlank(message = "学院不能为空")
    private String tid;

    @ApiModelProperty(value = "课程名")
    @NotNull(message = "专业不能为空")
    @NotBlank(message = "专业不能为空")
    private String cname;

    @ApiModelProperty(value = "开设学院")
    @NotNull(message = "班级不能为空")
    @NotBlank(message = "班级不能为空")
    private String ccollege;

    @ApiModelProperty(value = "开设年级")
    @NotNull(message = "课程名称不能为空")
    @NotBlank(message = "课程名称不能为空")
    private String cyear;

    @ApiModelProperty(value = "开设专业")
    @NotNull(message = "成绩不能为空")
    @NotBlank(message = "成绩不能为空")
    private String cmajor;

    @ApiModelProperty(value = "教务编号")
    @NotNull(message = "课程等级不能为空")
    @NotBlank(message = "课程等级不能为空")
    private String aid;
}
