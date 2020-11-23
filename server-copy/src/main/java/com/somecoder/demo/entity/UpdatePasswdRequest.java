package com.somecoder.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatePasswdRequest {

        @ApiModelProperty(value = "登陆名")
        @NotNull(message = "密码不能为空")
        @NotBlank(message = "密码不能为空")
        private String loginId;

        @ApiModelProperty(value = "新的密码，存的是md5")
        @NotNull(message = "密码不能为空")
        @NotBlank(message = "密码不能为空")
        private String newPasswd;

        @ApiModelProperty(value = "旧的密码，存的是md5")
        @NotNull(message = "密码不能为空")
        @NotBlank(message = "密码不能为空")
        private String oldPasswd;
}

