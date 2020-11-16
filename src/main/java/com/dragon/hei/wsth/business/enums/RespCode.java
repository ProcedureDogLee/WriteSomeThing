package com.dragon.hei.wsth.business.enums;

public enum RespCode {

    SUCC(0, "成功"),
    FAIL(-1, "失败"),

    ;

    private int code;

    private String msg;

    private RespCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
