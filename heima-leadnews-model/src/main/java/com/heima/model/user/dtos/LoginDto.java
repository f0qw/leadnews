package com.heima.model.user.dtos;

import lombok.Data;

@Data
public class LoginDto {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
