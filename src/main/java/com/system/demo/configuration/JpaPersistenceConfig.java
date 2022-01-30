package com.system.demo.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.system.demo.persistence.repository")
@PropertySource("classpath:application.properties")
@EntityScan(basePackages = {"com.system.demo.persistence.entity"})
public class JpaPersistenceConfig {

}
