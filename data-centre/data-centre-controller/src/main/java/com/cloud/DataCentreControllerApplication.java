package com.cloud;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class DataCentreControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCentreControllerApplication.class, args);
    }

    @Bean(
            name = {"masterDruidDataSource"}
    )
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
