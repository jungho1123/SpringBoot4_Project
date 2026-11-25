package com.inspirecamp7.myspringbootproject4.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CustomVO {
    private String mode;
    private double rate;
}
