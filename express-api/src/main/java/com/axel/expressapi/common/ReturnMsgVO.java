package com.axel.expressapi.common;


public class ReturnMsgVO<T> {
    private String message;
    private int code;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReturnMsgVO<T> ok() {
        ReturnMsgVO<T> vo = new ReturnMsgVO<>();
        vo.setCode(EnumReturnCodeInfo.OK.getCode());
        vo.setMessage(EnumReturnCodeInfo.OK.getMsg());
        return vo;
    }

    public ReturnMsgVO<T> ok(T t) {
        ReturnMsgVO<T> vo = new ReturnMsgVO<>();
        vo.setData(t);
        vo.setCode(EnumReturnCodeInfo.OK.getCode());
        vo.setMessage(EnumReturnCodeInfo.OK.getMsg());
        return vo;
    }
}
