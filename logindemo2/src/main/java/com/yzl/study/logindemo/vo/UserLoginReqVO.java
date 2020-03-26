package com.yzl.study.logindemo.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserLoginReqVO implements Serializable {

    @NotBlank( message="name不可为空")
    private String name;

    @NotBlank( message="password不可为空")
    private String password;


}
