package com.hsf302.shopbear.main;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.hsf302.shopbear.pojos")
@SpringBootApplication
@ComponentScan({ "com.hsf302.shopbear.controller","com.hsf302.shopbear.service"})
@EnableJpaRepositories(basePackages = "com.hsf302.shopbear.repositories")


public class ShopBearApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBearApplication.class, args);
    }

}
