package com.example.aliquid.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class WebAppBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAppBootApplication.class, args);
    }

}
