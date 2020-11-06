package com.dragon.hei.wsth.service.tenant.abstr;


import com.dragon.hei.wsth.mapper.TmpUserMapper;
import com.dragon.hei.wsth.mapper.po.TmpUser;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractUserService {

    @Autowired
    private TmpUserMapper tmpUserMapper;

    public Integer add(TmpUser user){
        return tmpUserMapper.insert(user);
    }

    public List<TmpUser> getUser(TmpUser user){
        TmpUser user1 = new TmpUser();
        user1.setId(1L);
        user1.setAge(20);
        user1.setName("小王");
        return Lists.newArrayList(user1);
    }
}
