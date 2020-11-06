package com.dragon.hei.wsth.config.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadContext {

    public static String ACCESS_CHANNEL = "dt-access-channel";
    public static String TENANT_ID = "dt-tenant-id";




    public static Long EMPTY_TENANT = -1L;


    private Map<String, String> contextMap = new ConcurrentHashMap<>();

    public void putKV(String k, String v){
        contextMap.put(k, v);
    }

    public String take(String k){
        return contextMap.get(k);
    }


}
