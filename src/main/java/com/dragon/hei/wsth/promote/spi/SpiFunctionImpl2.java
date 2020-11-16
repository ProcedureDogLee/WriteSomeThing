package com.dragon.hei.wsth.promote.spi;

import com.dragon.hei.wsth.business.mapper.po.TmpUser;

public class SpiFunctionImpl2 implements SpiFunction {
    @Override
    public void addUser(TmpUser user) {
        System.out.println("[SpiFunctionImpl2]:add... user...");
    }
}
