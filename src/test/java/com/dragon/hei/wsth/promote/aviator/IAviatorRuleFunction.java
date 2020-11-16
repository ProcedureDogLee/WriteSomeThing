package com.dragon.hei.wsth.promote.aviator;

import com.dragon.hei.wsth.promote.aviator.rule.AbstractAviatorRule;
import com.dragon.hei.wsth.promote.aviator.rule.CalculatorAviatorRule;
import com.dragon.hei.wsth.promote.aviator.rule.DefaultAviatorRule;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorContext;

import java.util.ArrayList;
import java.util.List;

public interface IAviatorRuleFunction {

    default AviatorContext buildContext(){
        AviatorContext context = new AviatorContext();
        context.setName("宋小宝");
        context.setAge(35);
        context.setClazz(3);
        context.setBonus(10d);
        context.setSalNum(20);
        return context;
    }

    default List<AbstractAviatorRule> rules(){

        AbstractAviatorRule rule1 = new DefaultAviatorRule();
        rule1.setRuleId(1001l);
        rule1.setExpression("age <= 40 && clazz >= 3 && string.startsWith(name, '宋')");

        AbstractAviatorRule rule2 = new CalculatorAviatorRule();
        rule2.setRuleId(1002l);
        rule2.setExpression("salNum * bonus * 10/100");

        List<AbstractAviatorRule> rules = new ArrayList<>();
        rules.add(rule1);
        rules.add(rule2);
        return rules;
    }
}
