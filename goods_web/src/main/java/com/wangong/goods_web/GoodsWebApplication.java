package com.wangong.goods_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@Component
public class GoodsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsWebApplication.class, args);
    }

}
