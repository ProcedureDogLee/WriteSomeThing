package com.dragon.hei.wsth.config.utils;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThreadContextCache {

    private static ThreadLocal<ThreadContext> tl = new TransmittableThreadLocal();

    public static void clear(){
        tl.remove();
    }

    private static ThreadContext getThreadContext(){
        ThreadContext tc = tl.get();
        if(null == tc){
            tc = new ThreadContext();
            tl.set(tc);
        }
        return tc;
    }

    public static void setTenantId(String tenantIdValue){
        ThreadContext tc = getThreadContext();
        tc.putKV(ThreadContext.TENANT_ID, tenantIdValue);
    }

    private static String getTenantIdValue(){
        ThreadContext tc = getThreadContext();
        return tc.take(ThreadContext.TENANT_ID);
    }

    public static Long getTenantId(){
        String tenant = getTenantIdValue();
        if(null == tenant){
            return ThreadContext.EMPTY_TENANT;
        }
        return Long.valueOf(tenant);
    }

    public static void setAccessChannel(String channel){
        ThreadContext tc = getThreadContext();
        tc.putKV(ThreadContext.ACCESS_CHANNEL, channel);
    }

    private static String getAccessChannelValue(){
        ThreadContext tc = getThreadContext();
        return tc.take(ThreadContext.ACCESS_CHANNEL);
    }

    public static Integer getAccessChannel(){
        String channel = getAccessChannelValue();
        return null == channel ? null : Integer.valueOf(channel);
    }
}
