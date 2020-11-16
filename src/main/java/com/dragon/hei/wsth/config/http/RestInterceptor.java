package com.dragon.hei.wsth.config.http;


import com.dragon.hei.wsth.config.utils.ThreadContext;
import com.dragon.hei.wsth.config.utils.ThreadContextCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RestInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessChannel = request.getHeader(ThreadContext.ACCESS_CHANNEL);
        if(null != accessChannel){
            ThreadContextCache.setAccessChannel(accessChannel);
        }
        String tenant = request.getHeader(ThreadContext.TENANT_ID);
        if(null != tenant){
            ThreadContextCache.setTenantId(accessChannel);
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        ThreadContextCache.clear();
    }
}
