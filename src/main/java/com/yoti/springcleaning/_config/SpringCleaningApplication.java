package com.yoti.springcleaning._config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yoti.springcleaning")
public class SpringCleaningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCleaningApplication.class, args);
    }
}
