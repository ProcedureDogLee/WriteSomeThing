package com.dragon.hei.wsth.business.service.tenant;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;

public interface ITenantService {

    default Integer insertUser(TmpUser user){
        return null;
    }

    TmpUser queryUser(Long userId);
}
