package com.inspirecamp7.myspringbootproject4.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@ComponentScan
@Order(value = 2)
public class MyRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
