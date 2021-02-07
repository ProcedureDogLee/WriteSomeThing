package com.dragon.hei.wsth.promote.channel;

import com.dragon.hei.wsth.WsthApplicationTests;
import com.dragon.hei.wsth.promote.channel.enums.SupplierEnum;
import org.junit.Test;

public class DataImportTest extends WsthApplicationTests {

    @Test
    public void rest(){
        DataImportUtil.match(SupplierEnum.S2).importData(null);
    }
}
