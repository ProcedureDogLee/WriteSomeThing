package com.dragon.hei.wsth.promote.channel;

import com.dragon.hei.wsth.promote.channel.enums.SupplierEnum;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorContext;
import org.springframework.stereotype.Service;

@Service
public class RestImportServiceImpl extends DataImportTemplate {

    @Override
    public SupplierEnum supplier() {
        return SupplierEnum.S1;
    }

    @Override
    protected AviatorContext convert(Object data) {
        System.out.println("Rest-Convert");
        return null;
    }

    @Override
    protected void imp(AviatorContext context) {
        System.out.println("Rest-Import");

    }
}
