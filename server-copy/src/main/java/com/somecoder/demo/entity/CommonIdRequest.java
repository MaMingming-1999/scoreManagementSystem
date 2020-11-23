package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "通用id请求")
public class CommonIdRequest {
    @ApiModelProperty(value = "通用id")
    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String id;
}
