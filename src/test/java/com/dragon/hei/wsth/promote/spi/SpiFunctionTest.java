package com.dragon.hei.wsth.promote.spi;

import com.dragon.hei.wsth.WsthApplicationTests;
import com.dragon.hei.wsth.promote.spi.test.SpiFunction;
import org.junit.Test;

import java.util.ServiceLoader;

public class SpiFunctionTest extends WsthApplicationTests {

    @Test
    public void spi(){
        ServiceLoader<SpiFunction> spifunctions = ServiceLoader.load(SpiFunction.class);
        System.out.println("spi接口实现类已加载完毕，即将启动函数...");
        for (SpiFunction spifunction : spifunctions) {
            spifunction.addUser(null);
        }
    }
}
