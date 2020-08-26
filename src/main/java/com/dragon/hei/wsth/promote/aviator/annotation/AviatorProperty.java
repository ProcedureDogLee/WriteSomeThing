package com.dragon.hei.wsth.promote.aviator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* AviatorContext属性名+中文描述
* 如name=fundedAmount，desc=实收金额
**/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AviatorProperty {
    String value() default "";
    String name() default "";
    String desc() default "";
}
