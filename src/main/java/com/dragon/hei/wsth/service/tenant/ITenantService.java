package com.dragon.hei.wsth.service.tenant;

import com.dragon.hei.wsth.mapper.po.TmpUser;

public interface ITenantService {

    default Integer insertUser(TmpUser user){
        return null;
    }

    TmpUser queryUser(Long userId);
}
