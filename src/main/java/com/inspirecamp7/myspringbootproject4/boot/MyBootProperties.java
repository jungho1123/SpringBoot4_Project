package com.inspirecamp7.myspringbootproject4.boot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("myboot")
public class MyBootProperties {


    private String myBootName;
    private int myBootAge;
    private String fullName;


}
