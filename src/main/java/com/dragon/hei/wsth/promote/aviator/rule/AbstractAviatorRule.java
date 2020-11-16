package com.dragon.hei.wsth.promote.aviator.rule;

import com.dragon.hei.wsth.promote.vo.aviator.AviatorContext;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorResult;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractAviatorRule {

    // 规则id主键
    private Long ruleId;

    // 规则表达式
    private String expression;

    // 表达式执行结果
    private AviatorResult result;

    public AbstractAviatorRule(){}

    public AbstractAviatorRule(Long ruleId, String expression){
        this.ruleId = ruleId;
        this.expression = expression;
    }

    /***
     * 执行规则表达式
     * @param param
     * @param ruleChain
     * @param response：表达式执行结果
     */
    public abstract void execute(AviatorContext param, List<AbstractAviatorRule> response);
}
