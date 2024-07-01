package org.springtransactional.lesson1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.springtransactional.lesson1")
@EnableTransactionManagement
public class ProductConfig {

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    DataSource dataSource(){
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/store",
                "docker",
                "docker"
        );
    }

    @Bean
    TransactionManager transactionManager (DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
