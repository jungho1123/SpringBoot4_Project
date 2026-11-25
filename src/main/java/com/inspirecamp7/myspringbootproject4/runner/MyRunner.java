package com.inspirecamp7.myspringbootproject4.runner;

import com.inspirecamp7.myspringbootproject4.boot.MyBootProperties;
import com.inspirecamp7.myspringbootproject4.config.CustomVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Order(value = 2)
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    String myBootName;
    @Value("${myboot.age}")
    int myBootAge;

    @Autowired
    Environment environment;
    @Autowired
    MyBootProperties myBootProperties;

    @Autowired
    CustomVO  customVO;
    //Logger 객체 생성
    Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("환경변수 MyRunner myboot.name= {}", myBootName);
        logger.debug("myboot.name check{}", args.getOptionValues("myboot.name"));
        logger.debug("myboot.age check{}", myBootAge);
        logger.debug("myfullName={}", environment.getProperty("myboot.fullName"));


        // 환경 변수 목록 확인하기
        Set<String> optionArgs = args.getOptionNames();
        for (String optionArg : optionArgs) {
            System.out.println("optionArg = " + optionArg);
        }

        //함수형 인터페이스 Consumer 의 추상 메서드 void accept(T t)
        args.getOptionNames().forEach(name -> System.out.println("optionArg = " + name));
        // 메서드 reference로 표현하기
        args.getOptionNames().forEach(System.out::println);

        optionArgs.forEach(System.out::println);

        logger.info("myBootProperties{}", myBootProperties.getFullName());
        logger.info("myBootProperties{}", myBootProperties.getMyBootAge());
        logger.info("myBootProperties{}", myBootProperties.getMyBootName());


    }
}
