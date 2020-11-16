package com.dragon.hei.wsth.promote.dynamic;

import com.alibaba.fastjson.JSON;
import com.dragon.hei.wsth.WsthApplicationTests;
import com.dragon.hei.wsth.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.factory.DynamicBeanFactory;
import com.dragon.hei.wsth.service.tenant.ITenantService;
import org.junit.Test;

public class DynamicLoadingBeanTest extends WsthApplicationTests {

    @Test
    public void queryUser(){
        Long userId = 1l;
        TmpUser user = DynamicBeanFactory.tagBean(ITenantService.class).queryUser(userId);
        System.out.println(JSON.toJSONString(user));
    }
}
