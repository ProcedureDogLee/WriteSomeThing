package com.dragon.hei.wsth.promote.aviator.rule;

import com.dragon.hei.wsth.promote.aviator.AviatorExecutor;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorContext;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DefaultAviatorRule extends AbstractAviatorRule {

    @Override
    public void execute(AviatorContext param, List<AbstractAviatorRule> response) {

        super.setResult(executeAndResult(param));
        response.add(this);
    }

    protected AviatorResult executeAndResult(AviatorContext param){

        AviatorResult resultInfo = new AviatorResult();
        try {

            boolean result = AviatorExecutor.execute(param, super.getExpression());
            resultInfo.setSuccess(result);
        }catch (Exception e){
            log.error("DefaultAviatorRule execute error: {}", e);
        }
        return resultInfo;
    }
}

