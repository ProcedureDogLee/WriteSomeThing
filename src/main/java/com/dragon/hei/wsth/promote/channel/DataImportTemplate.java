package com.dragon.hei.wsth.promote.channel;

import com.dragon.hei.wsth.promote.channel.enums.SupplierEnum;
import com.dragon.hei.wsth.promote.vo.aviator.AviatorContext;

/**
 * @Description:
 * @Author: lilong
 **/
public abstract class DataImportTemplate {

    public void importData(Object data){
        System.out.println("Data-Import-Template Begin");

        AviatorContext context = convert(data);
        check(context);
        imp(context);
        System.out.println("Data-Import-Template end");
    }

    private void check(AviatorContext context){
        //check data
    }

    protected abstract AviatorContext convert(Object data);

    protected abstract void imp(AviatorContext context);

    protected abstract SupplierEnum supplier();
}
