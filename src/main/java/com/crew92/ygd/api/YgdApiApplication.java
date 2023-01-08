package com.crew92.ygd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class YgdApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YgdApiApplication.class, args);
    }

}
