package com.dragon.hei.wsth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dragon.hei.wsth.mapper")
public class WsthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsthApplication.class, args);
    }

}
