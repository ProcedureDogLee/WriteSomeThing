package com.dragon.hei.wsth.business.vo;

import com.dragon.hei.wsth.business.enums.RespCode;
import lombok.Data;

/**
 * @Description:
 * @Author: lilong
 **/
@Data
public class ResponseVo<T> {

    private int code;

    private String msg;

    private boolean success;

    private T data;

    private ResponseVo(){}

    private ResponseVo(T data, RespCode respCode){
        this(data, respCode.getCode(), respCode.getMsg());
    }

    private ResponseVo(T data, int code, String msg){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseVo success(Object data){
        ResponseVo responseVo = new ResponseVo(data, RespCode.SUCC);
        responseVo.setSuccess(true);
        return responseVo;
    }

    public static ResponseVo success(Object data, RespCode respCode){
        ResponseVo responseVo = new ResponseVo(data, respCode);
        responseVo.setSuccess(true);
        return responseVo;
    }

    public static ResponseVo fail(){
        return new ResponseVo(null, RespCode.FAIL);
    }

    public static ResponseVo fail(RespCode respCode){
        return new ResponseVo(null, respCode);
    }

    public static ResponseVo fail(String msg){
        return new ResponseVo(null, RespCode.FAIL.getCode(), msg);
    }
}
