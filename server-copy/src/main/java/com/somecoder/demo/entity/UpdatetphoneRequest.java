package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatetphoneRequest {
    @ApiModelProperty(value = "工号")
    @NotNull(message = "工号不能为空")
    @NotBlank(message = "工号不能为空")
    private String tid;

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "手机号不能为空")
    @NotBlank(message = "手机号不能为空")
    private String tphone;
}
