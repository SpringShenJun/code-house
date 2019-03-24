package com.csj2;

import com.csj.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 单实例多实例
 */
@Configuration
public class Main2Config {

    /**
     *
     * 给他容器中注册一个bean，默认是单实例
     * prototype：多实例，ioc容器启动的时候，ioc容器启动并不会去调用方法创建对象，而是在对象使用的时候才会去调用方法去创建对象
     * singleton:单实例(默认) ioc容器在启动的时候就已经调用方法去创建对象，以后每次获取都是从ioc容器中(map中get)的同一个bean
     * request:主要针对web应用，递交一次请求创建一个实例。
     * session:同一个session创建一个实例。
     *
     */
    @Bean //默认是单实例
    @Scope(value = "prototype")
    public Person person() {

        return new Person(100,"csj");
    }
}
