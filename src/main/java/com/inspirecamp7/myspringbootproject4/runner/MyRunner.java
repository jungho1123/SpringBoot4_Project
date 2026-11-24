package com.inspirecamp7.myspringbootproject4.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

@ComponentScan
@Order(value = 2)
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    String myBootName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("환경변수 MyRunner myboot.name= " + myBootName);

    }
}
