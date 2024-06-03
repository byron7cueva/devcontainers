package com.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.webapi"})
public class WebapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class);

    }
}