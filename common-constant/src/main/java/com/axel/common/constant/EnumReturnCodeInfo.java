package com.axel.common.constant;

import lombok.Getter;

public enum EnumReturnCodeInfo {
    OK("ok", 0),
    ERROR("error", 1),
    ;

    @Getter
    private final String msg;
    @Getter
    private final int code;

    EnumReturnCodeInfo(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
