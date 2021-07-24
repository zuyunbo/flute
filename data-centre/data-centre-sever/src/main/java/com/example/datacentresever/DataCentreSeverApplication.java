package com.example.datacentresever;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zuyunbo
 */
@ComponentScan({"com.cloud"})
@MapperScan({"com.cloud.mapper"})
@SpringBootApplication
public class DataCentreSeverApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataCentreSeverApplication.class, args);
    }
}
