package com.saramin.lab.resumeitr.batch.jdbc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA on 2017-12-22 14:59
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : DatabaseConfig
 * Descrption :
 */

/*

@Configuration
@MapperScan("com.saramin.lab.resumeitr.batch.mapper")
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource
            , ApplicationContext applicationContext)  throws IOException{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*Mapper.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactroy){
        return new SqlSessionTemplate(sqlSessionFactroy);
    }

}
*/
