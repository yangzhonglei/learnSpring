package com.yzl.study.logindemo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterReqVO {

    @NotBlank( message="name不可为空")
    private String name;

    @NotBlank( message="password不可为空")
    private String password;

    @NotBlank( message="validCode不可为空")
    private String validCode;

    @NotBlank( message="phone不可为空")
    private String phone;

}
