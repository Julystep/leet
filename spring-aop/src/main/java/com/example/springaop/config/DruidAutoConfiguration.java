package com.example.springaop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: liml
 * @date: 2022/5/18
 */
@Configuration
public class DruidAutoConfiguration {

    DynamicDataSourceProvider dynamicDataSourceProvider;

    @Autowired
    public void setDynamicDataSourceProvider(DynamicDataSourceProvider dynamicDataSourceProvider) {
        this.dynamicDataSourceProvider = dynamicDataSourceProvider;
    }

    @Bean
    DynamicDataSource dynamicDataSource() {
        return new DynamicDataSource(dynamicDataSourceProvider);
    }

}