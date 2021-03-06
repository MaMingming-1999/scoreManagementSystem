package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatetemailRequest {
    @ApiModelProperty(value = "工号")
    @NotNull(message = "工号不能为空")
    @NotBlank(message = "工号不能为空")
    private String id;

    @ApiModelProperty(value = "邮箱")
    @NotNull(message = "邮箱不能为空")
    @NotBlank(message = "邮箱不能为空")
    private String temail;
}
