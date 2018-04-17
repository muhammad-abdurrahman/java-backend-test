package com.yoti.springcleaning._config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.yoti.springcleaning")
@EnableJpaRepositories(basePackages = "com.yoti.springcleaning.repository")
@EntityScan(basePackages = "com.yoti.springcleaning.persistence")
public class SpringCleaningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCleaningApplication.class, args);
    }
}
