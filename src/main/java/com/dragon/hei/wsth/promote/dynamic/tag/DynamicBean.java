package com.dragon.hei.wsth.promote.dynamic.tag;

import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DynamicBean {

    String value() default "";

    AccessChannel accessChannel() default AccessChannel.Pc;

    String tenantId() default "-1";
}
