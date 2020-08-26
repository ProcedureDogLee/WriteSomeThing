package com.dragon.hei.wsth.promote.aviator;

import com.dragon.hei.wsth.vo.aviator.AviatorContext;
import com.googlecode.aviator.AviatorEvaluator;

import java.util.Map;

/**
 * @Description:
 * @Author: lilong
 **/
public class AviatorExecutor {

    public static <T> T execute(AviatorContext context, String expression){

        Map<String, Object> param = AviatorContext.buildMap(context);
        return (T) AviatorEvaluator.execute(expression, param, true);
    }
}
