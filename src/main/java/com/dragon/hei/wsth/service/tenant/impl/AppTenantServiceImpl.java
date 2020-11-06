package com.dragon.hei.wsth.service.tenant.impl;

import com.dragon.hei.wsth.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;
import com.dragon.hei.wsth.promote.dynamic.tag.TenantOrderTag;
import com.dragon.hei.wsth.service.tenant.ITenantService;
import org.springframework.stereotype.Service;

@Service
@TenantOrderTag(accessChannel = AccessChannel.App)
public class AppTenantServiceImpl implements ITenantService {
    @Override
    public TmpUser queryUser(Long userId) {
        return null;
    }
}
