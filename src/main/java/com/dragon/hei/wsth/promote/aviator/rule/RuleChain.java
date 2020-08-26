package com.dragon.hei.wsth.promote.aviator.rule;

import com.dragon.hei.wsth.vo.aviator.AviatorContext;

import java.util.List;

public interface RuleChain {

    /***
     * 匹配规则表达式chain
     * @param context
     * @param response：表达式执行结果
     */
    void matchRule(AviatorContext context, List<AbstractAviatorRule> response);
}
