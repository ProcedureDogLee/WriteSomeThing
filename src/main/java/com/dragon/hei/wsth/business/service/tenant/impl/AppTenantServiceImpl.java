package com.dragon.hei.wsth.business.service.tenant.impl;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;
import com.dragon.hei.wsth.promote.dynamic.tag.DynamicBean;
import com.dragon.hei.wsth.business.service.tenant.ITenantService;
import org.springframework.stereotype.Service;

@Service
@DynamicBean(accessChannel = AccessChannel.App)
public class AppTenantServiceImpl implements ITenantService {
    @Override
    public TmpUser queryUser(Long userId) {
        return null;
    }
}
