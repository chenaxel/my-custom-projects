package com.axel.common.constant;


import lombok.Data;

@Data
public class ReturnMsgVO<T> {
    private String message;
    private int code;
    private T data;

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
