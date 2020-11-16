package com.dragon.hei.wsth.promote.dynamic.factory;

import com.dragon.hei.wsth.config.utils.ThreadContextCache;
import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;
import com.dragon.hei.wsth.promote.dynamic.tag.DynamicBean;
import com.dragon.hei.wsth.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
public class DynamicBeanFactory {

    /***
     * 实现类必须指定{@link DynamicBean}注解<p/>
     * 当前请求的'accessChannel'和'tenantId'必须存在<p/>
     *
     * bean加载优先级由高到低:<p/>
     * 1.accessChannel + tenantId 精确匹配
     * 2.accessChannel + '-1' ('-1'是指实现类父级别实现, 未被租户定制; 非'-1'指租户定制实现类)
     * 3.AccessChannel.Pc + tenantId
     * 4.AccessChannel.Pc + '-1'
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T tagBean(Class<T> clz){

        abstractClassOnly(clz);

        // TODO：自适配获取channel信息
        Integer accessChannel = Optional.ofNullable(ThreadContextCache.getAccessChannel()).orElse(AccessChannel.Pc.k());
        // TODO：自适配获取租户信息
        Long tenantId = ThreadContextCache.getTenantId();
        log.info("渠道={},租户={}", accessChannel, tenantId);

        T returnBean = get(accessChannel, tenantId, clz);
        Assert.notNull(returnBean, String.format("类'%s'未匹配到bean", clz.getSimpleName()));
        //TODO
//        log.info("渠道租户定制类匹配到'{}'", returnBean.getClass().getSuperclass().getSimpleName());
        log.info("渠道租户定制类匹配到'{}'", returnBean.getClass().getSimpleName());
        return returnBean;
    }

    private static void abstractClassOnly(Class cls){
        boolean isInterface = cls.isInterface();
        boolean isAbstract = Modifier.isAbstract(cls.getModifiers());
        if(!isInterface && !isAbstract){
            throw new RuntimeException(String.format("类'%s'不是抽象类或接口", cls.getSimpleName()));
        }
    }

    private static <T> T get(Integer accessChannel, Long tenantId, Class<T> clz){
        // key为渠道+租户，value为bean
        Map<String, T> beanMap = beanMap(clz);
        // 优先级由高到低
        String key1 = beanKey(accessChannel, String.valueOf(tenantId));
        String key2 = beanKey(accessChannel, "-1");
        String key3 = beanKey(AccessChannel.Pc.k(), String.valueOf(tenantId));
        String key4 = beanKey(AccessChannel.Pc.k(), "-1");
        if(beanMap.containsKey(key1)){
            return beanMap.get(key1);
        }
        if(beanMap.containsKey(key2)){
            return beanMap.get(key2);
        }
        if(beanMap.containsKey(key3)){
            return beanMap.get(key3);
        }
        if(beanMap.containsKey(key4)){
            return beanMap.get(key4);
        }
        return null;
    }

    private static <T> Map<String, T> beanMap(Class<T> clz){
        Map<String, T> beans = ApplicationContextUtil.getBeansOfType(clz);
        Map<String, T> beanMap = new HashMap<>();
        for(Map.Entry<String, T> entry : beans.entrySet()){
            T bean = entry.getValue();
            // TODO:spring管理的bean是生成的代理对象，这里获取原始类拿到注解信息
//            Class srcCls = bean.getClass().getSuperclass();
            Class srcCls = bean.getClass();
            DynamicBean tag = (DynamicBean) srcCls.getAnnotation(DynamicBean.class);
            Integer _channel;
            String _tenant;
            if(null != tag){
                _channel = tag.accessChannel().k();
                _tenant = tag.tenantId();
            }else{
                throw new RuntimeException(String.format("类'%s'缺失'DynamicBean'注解", srcCls.getSimpleName()));
            }
            String key = beanKey(_channel, _tenant);
            T replaced = beanMap.put(key, entry.getValue());
            if(null != replaced){
                Class replCls = replaced.getClass().getSuperclass();
                String msg = "注解'DynamicBean'在类'%s'和'%s'之间发生冲突，请确认注解配置'accessChannel'和'tenantId'组合是否正确";
                throw new RuntimeException(String.format(msg, replCls.getSimpleName(), srcCls.getSimpleName()));
            }
        }
        return beanMap;
    }

    private static String beanKey(Integer accessChannel, String tenantId){
        return new StringBuilder().append(accessChannel).append("#").append(tenantId).toString();
    }
}
