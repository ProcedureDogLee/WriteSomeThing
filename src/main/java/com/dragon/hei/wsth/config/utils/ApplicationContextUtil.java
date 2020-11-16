package com.dragon.hei.wsth.config.utils;


import org.springframework.context.ApplicationContext;

import java.util.Map;

public class ApplicationContextUtil {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        applicationContext = context;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clz){
        return applicationContext.getBeansOfType(clz);
    }

}
