package com.dragon.hei.wsth.service.aviator.rule;

import com.dragon.hei.wsth.service.aviator.AviatorExecutor;
import com.dragon.hei.wsth.vo.aviator.AviatorContext;
import com.dragon.hei.wsth.vo.aviator.AviatorResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorAviatorRule extends DefaultAviatorRule {

    @Override
    protected AviatorResult executeAndResult(AviatorContext param){

        AviatorResult resultInfo = new AviatorResult();
        try {

            Double result = AviatorExecutor.execute(param, super.getExpression());
            resultInfo.setSuccess(true);
            resultInfo.setResult(result);
        }catch (Exception e){
            log.error("CalculatorAviatorRule execute error: {}", e);
        }
        return resultInfo;
    }
}
