package com.csj.config;

import com.csj.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public Person person02() {

        return new Person(2,"csj");
    }
}
