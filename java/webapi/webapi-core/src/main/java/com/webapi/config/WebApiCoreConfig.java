package com.webapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.webapi.common.data.listeners.AuditListenerConfig;

@Configuration
@Import({ AuditListenerConfig.class })
@EntityScan(basePackages = "com.webapi")
@EnableJpaRepositories(basePackages = "com.webapi")
@ComponentScan(basePackages = "com.webapi")
@EnableTransactionManagement
public class WebApiCoreConfig {

}
