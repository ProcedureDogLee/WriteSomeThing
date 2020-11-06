package com.dragon.hei.wsth.service.tenant.impl;

import com.dragon.hei.wsth.mapper.po.TmpUser;
import com.dragon.hei.wsth.promote.dynamic.enums.AccessChannel;
import com.dragon.hei.wsth.promote.dynamic.tag.TenantOrderTag;
import com.dragon.hei.wsth.service.tenant.ITenantService;
import com.dragon.hei.wsth.service.tenant.abstr.AbstractUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@TenantOrderTag(accessChannel = AccessChannel.Pc)
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
