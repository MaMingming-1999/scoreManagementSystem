package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AIdRequest {
    @ApiModelProperty(value = "教务编号")
    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String id;
}
