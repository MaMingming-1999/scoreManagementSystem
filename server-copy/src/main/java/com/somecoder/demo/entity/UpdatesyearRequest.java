package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatesyearRequest {
    @ApiModelProperty(value = "学号")
    @NotNull(message = "学号不能为空")
    @NotBlank(message = "学号不能为空")
    private String sid;

    @ApiModelProperty(value = "学级")
    @NotNull(message = "学级不能为空")
    @NotBlank(message = "学级不能为空")
    private String syear;
}
