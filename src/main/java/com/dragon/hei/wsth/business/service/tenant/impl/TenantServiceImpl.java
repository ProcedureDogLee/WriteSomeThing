package com.dragon.hei.wsth.business.service.tenant.impl;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;
import com.dragon.hei.wsth.promote.dynamic.tag.DynamicBean;
import com.dragon.hei.wsth.business.service.tenant.ITenantService;
import com.dragon.hei.wsth.business.service.tenant.abstr.AbstractUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DynamicBean(accessChannel = AccessChannel.Pc)
public class TenantServiceImpl extends AbstractUserService implements ITenantService {

    @Override
    public Integer insertUser(TmpUser user) {
        return super.add(user);
    }

    @Override
    public TmpUser queryUser(Long userId) {
        List<TmpUser> users = super.getUser(null);
        return users.stream().findFirst().orElse(null);
    }

}
