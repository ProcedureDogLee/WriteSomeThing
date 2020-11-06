package com.dragon.hei.wsth.promote.dynamic.enums;

public enum AccessChannel {

    Pc(10, "PC系统"),
    App(20, "APP"),

    ;

    private Integer key;
    private String desc;

    AccessChannel(Integer key, String desc){
        this.key = key;
        this.desc = desc;
    }

    public Integer k(){
        return this.key;
    }

    public String desc(){
        return this.desc;
    }

}
