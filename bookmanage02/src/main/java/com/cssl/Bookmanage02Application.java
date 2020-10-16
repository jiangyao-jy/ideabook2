package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.cssl.dao")

public class Bookmanage02Application {

    public static void main(String[] args) {

        SpringApplication.run(Bookmanage02Application.class, args);
    }

}
