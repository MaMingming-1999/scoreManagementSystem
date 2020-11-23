package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "登录请求")
public class LoginRequest {

    @ApiModelProperty(value = "学生登陆名")
    @NotNull(message = "登录名不能为空")
    @NotBlank(message = "登陆名不能为空")
    private String sid;

    @ApiModelProperty(value = "密码，存的是md5")
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String spassword;
}
