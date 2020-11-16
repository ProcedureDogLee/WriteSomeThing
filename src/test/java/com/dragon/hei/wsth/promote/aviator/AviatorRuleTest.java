package com.dragon.hei.wsth.promote.aviator;

import com.alibaba.fastjson.JSON;
import com.dragon.hei.wsth.WsthApplicationTests;
import com.dragon.hei.wsth.promote.aviator.rule.AbstractAviatorRule;
import com.dragon.hei.wsth.promote.aviator.rule.DefaultRuleChain;
import com.dragon.hei.wsth.promote.aviator.rule.RuleChain;
import com.dragon.hei.wsth.vo.aviator.AviatorContext;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AviatorRuleTest extends WsthApplicationTests implements IAviatorRuleFunction{

    @Test
    public void ruleMatchTest1(){
        // aviator上下文
        AviatorContext context = buildContext();

        // 存储表达式执行结果
        List<AbstractAviatorRule> response = new ArrayList<>();

        // 规则chain
        RuleChain ruleChain = new DefaultRuleChain(rules());
        ruleChain.matchRule(context, response);

        System.out.println("规则链执行结果："+ JSON.toJSONString(response));
    }
}
