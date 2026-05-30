package com.axel.common.constant.password;

import lombok.Data;

@Data
public class PasswordResult {
    /**
     * 生成的密码
     */
    private String password;
    /**
     * 安全等级：弱/中/强
     */
    private String level;
}
