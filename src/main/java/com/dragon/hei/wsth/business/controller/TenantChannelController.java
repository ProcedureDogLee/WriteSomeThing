package com.dragon.hei.wsth.business.controller;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.factory.DynamicBeanFactory;
import com.dragon.hei.wsth.business.service.tenant.ITenantService;
import com.dragon.hei.wsth.business.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lilong
 **/
@RequestMapping("/tenant/channel")
@RestController
public class TenantChannelController {

    @RequestMapping(value = "/user/query", method = RequestMethod.GET)
    public ResponseVo<TmpUser> queryUser(@RequestParam Long userId){
        TmpUser user = DynamicBeanFactory.tagBean(ITenantService.class).queryUser(userId);
        return ResponseVo.success(user);
    }

    @RequestMapping(value = "/user/query2", method = RequestMethod.GET)
    public ResponseVo<TmpUser> queryUser2(@RequestParam Long userId){
        TmpUser user = DynamicBeanFactory.tagBean(ITenantService.class).queryUser(userId);
        return ResponseVo.success(user);
    }
}
