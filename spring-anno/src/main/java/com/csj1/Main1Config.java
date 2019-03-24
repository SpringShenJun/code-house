package com.csj1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan(value = "com.csj1")

//@ComponentScan(value = "com.csj1", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
//}, useDefaultFilters = false)
//使用includeFilters需要关闭默认的过滤器设置即useDefaultFilter = false

@ComponentScan(value = "com.csj1", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, value = CsjFilter.class)
},useDefaultFilters = false)

public class Main1Config {
}

