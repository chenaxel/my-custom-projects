package com.axel.expressapi.common;

public enum EnumReturnCodeInfo {
    OK ("ok", 0),
    ERROR("error", 1),
    ;

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    EnumReturnCodeInfo(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
