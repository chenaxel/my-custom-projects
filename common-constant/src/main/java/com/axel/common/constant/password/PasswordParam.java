package com.axel.common.constant.password;

import lombok.Data;

@Data
public class PasswordParam {
    /**
     * 密码长度
     */
    private Integer length;
    /**
     * 是否包含数字
     */
    private Boolean hasNumber;
    /**
     * 是否包含小写字母
     */
    private Boolean hasLower;
    /**
     * 是否包含大写字母
     */
    private Boolean hasUpper;
    /**
     * 是否包含特殊字符
     */
    private Boolean hasSymbol;
}
