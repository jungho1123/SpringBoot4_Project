package com.inspirecamp7.myspringbootproject4.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Component
@Order(value = 1)
@Slf4j
public class DataBaseRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(dataSource.getClass().getName());
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            log.info("Database Name: {}", metaData.getDatabaseProductName());
            log.info("Database Version: {}", metaData.getDatabaseProductVersion());
            log.info("db url:{}",metaData.getURL());
            log.info("db name:{}",metaData.getUserName());
        }

    }
}
