package com.dragon.hei.wsth.promote.channel.enums;


public enum SupplierEnum {

    S1(1001L, "S1"),
    S2(1002L, "S2"),
    ;


    private long id;
    private String name;

    SupplierEnum(long id, String name){
        this.id = id;
        this.name = name;
    }

}
