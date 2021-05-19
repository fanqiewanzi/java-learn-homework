package com.example.learn1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.learn1.dao")
@SpringBootApplication
public class Learn1Application {

    public static void main(String[] args) {
        SpringApplication.run(Learn1Application.class, args);
    }

}
