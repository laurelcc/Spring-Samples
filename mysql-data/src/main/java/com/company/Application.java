package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by huanbenwang on 2017/7/6.
 */
@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
