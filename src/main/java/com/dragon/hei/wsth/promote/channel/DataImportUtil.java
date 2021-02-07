package com.dragon.hei.wsth.promote.channel;

import com.dragon.hei.wsth.config.context.ApplicationContextUtil;
import com.dragon.hei.wsth.promote.channel.enums.SupplierEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataImportUtil implements InitializingBean {

    private static Map<SupplierEnum, DataImportTemplate> templateMap = new HashMap<>();

    public static DataImportTemplate match(SupplierEnum supplier){
        DataImportTemplate template = templateMap.get(supplier);
        Assert.notNull(template, String.format("未匹配到%s相关的bean", supplier));
        return template;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, DataImportTemplate> templates = ApplicationContextUtil.getBeansOfType(DataImportTemplate.class);
        templates.values().stream().forEach(x -> templateMap.put(x.supplier(), x));
    }
}
