package com.dragon.hei.wsth.promote.spi.test;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;

public class SpiFunctionImpl implements SpiFunction{
    @Override
    public void addUser(TmpUser user) {
        System.out.println("[SpiFunctionImpl]:add... user...");
    }

}
