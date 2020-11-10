package com.dragon.hei.wsth.promote.spi.test;

import com.dragon.hei.wsth.mapper.po.TmpUser;

import java.util.ServiceLoader;

public class SpiFunctionImpl implements SpiFunction{
    @Override
    public void addUser(TmpUser user) {
        System.out.println("[SpiFunctionImpl]:add... user...");
    }

    public static void main(String[] args) {
        ServiceLoader<SpiFunction> spifunctions = ServiceLoader.load(SpiFunction.class);
        System.out.println("ins ...add... user...");
        for (SpiFunction spifunction : spifunctions) {
            spifunction.addUser(null);
        }
    }
}
