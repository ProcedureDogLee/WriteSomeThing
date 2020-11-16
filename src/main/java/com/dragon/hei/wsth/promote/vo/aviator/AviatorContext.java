package com.dragon.hei.wsth.promote.vo.aviator;

import com.dragon.hei.wsth.promote.aviator.annotation.AviatorProperty;
import lombok.Data;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/***
 * aviator上下文变量因子
 */
@Data
public class AviatorContext {

    @AviatorProperty("姓名")
    private String name;

    @AviatorProperty("年龄")
    private Integer age = 0;

    @AviatorProperty("职级")
    private Integer clazz = 0;

    @AviatorProperty("提成")
    private Double bonus;

    @AviatorProperty("销售数量")
    private Integer salNum;

    /***
     * 将对象转为Map
     * @param context
     * @return
     */
    public static Map<String, Object> buildMap(AviatorContext context){
        Map<String, Object> env = new HashMap<>();
        if(null == context){
            return env;
        }
        List<Field> fieldList = new ArrayList<>();
        Class clz = context.getClass();
        int deep = 0;
        while(deep < 5 && null != clz){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clz.getDeclaredFields())));
            clz = clz.getSuperclass();
            deep++;
        }
        for(Field field : fieldList){
            try {
                PropertyDescriptor property = new PropertyDescriptor(field.getName(), context.getClass());
                Method method = property.getReadMethod();
                env.put(field.getName(), method.invoke(context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return env;
    }
}
