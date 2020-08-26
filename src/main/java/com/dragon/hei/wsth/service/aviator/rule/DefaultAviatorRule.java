package com.dragon.hei.wsth.service.aviator.rule;

import com.alibaba.fastjson.JSON;
import com.dragon.hei.wsth.service.aviator.AviatorExecutor;
import com.dragon.hei.wsth.vo.aviator.AviatorContext;
import com.dragon.hei.wsth.vo.aviator.AviatorResult;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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

class TestMain{
    public static void main(String[] args) {

        // aviator上下文
        AviatorContext context = buildContext();

        // 存储表达式执行结果
        List<AbstractAviatorRule> response = new ArrayList<>();

        // 规则chain
        RuleChain ruleChain = new DefaultRuleChain(rules());
        ruleChain.matchRule(context, response);

        System.out.println(JSON.toJSONString(response));
    }

    private static AviatorContext buildContext(){
        AviatorContext context = new AviatorContext();
        context.setName("宋小宝");
        context.setAge(35);
        context.setClazz(3);
        context.setBonus(10d);
        context.setSalNum(20);
        return context;
    }

    private static List<AbstractAviatorRule> rules(){

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