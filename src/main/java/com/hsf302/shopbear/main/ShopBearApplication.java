package com.hsf302.shopbear.main;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.hsf302.shopbear.pojos")
@SpringBootApplication
public class ShopBearApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBearApplication.class, args);
    }

}
