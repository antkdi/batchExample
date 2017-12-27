package com.saramin.lab.resumeitr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA on 2017-12-22 14:25
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : batchApplication
 * Descrption :
 */

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
@SpringBootApplication
public class batchApplication {

    public static void main(String[] args) {
        SpringApplication.run(batchApplication.class, args);
    }
}
