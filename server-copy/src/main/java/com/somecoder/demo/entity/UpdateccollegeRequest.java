package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateccollegeRequest {

    @ApiModelProperty(value = "课程编号")
    @NotNull(message = "课程编号不能为空")
    @NotBlank(message = "课程编号不能为空")
    private String cid;

    @ApiModelProperty(value = "开设学院")
    @NotNull(message = "开设学院不能为空")
    @NotBlank(message = "开设学院不能为空")
    private String ccollege;

}
