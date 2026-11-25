package com.inspirecamp7.myspringbootproject4.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomVO {
    private String mode;
    private double rate;
}
