package com.dragon.hei.wsth.vo.aviator;

import lombok.Data;

@Data
public class AviatorResult {

    private boolean success;

    private Object result;

    public AviatorResult(){}

    public AviatorResult(boolean success){
        this(success, null);
    }

    public AviatorResult(boolean success, Object result){
        this.success = success;
        this.result = result;
    }
}
