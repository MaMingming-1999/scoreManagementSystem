package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TeacherRequest {
    @ApiModelProperty(value = "工号")
    @NotNull(message = "工号不能为空")
    @NotBlank(message = "工号不能为空")
    private String tid;

    @ApiModelProperty(value = "教师姓名")
    @NotNull(message = "教师姓名不能为空")
    @NotBlank(message = "教师姓名不能为空")
    private String tname;

    @ApiModelProperty(value = "教师电话")
    @NotNull(message = "教师电话不能为空")
    @NotBlank(message = "教师电话不能为空")
    private String tphone;

    @ApiModelProperty(value = "教师密码")
    @NotNull(message = "教师密码不能为空")
    @NotBlank(message = "教师密码不能为空")
    private String tpassword;

    @ApiModelProperty(value = "教师学院")
    @NotNull(message = "教师学院不能为空")
    @NotBlank(message = "教师学院不能为空")
    private String tcollege;

    @ApiModelProperty(value = "教师邮箱")
    @NotNull(message = "教师邮箱不能为空")
    @NotBlank(message = "教师邮箱不能为空")
    private String temail;

}
