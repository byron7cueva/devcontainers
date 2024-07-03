package com.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.webapi.config.AuditConfig;
import com.webapi.config.WebApiCoreConfig;

@Import({ WebApiCoreConfig.class, AuditConfig.class })
@SpringBootApplication(scanBasePackages = { "com.webapi" })
public class WebapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class);

    }
}