package com.csj4;

import com.csj.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
public class Main4Config {


    @Bean
    @Conditional(WinCondition.class)
    public Person spring() {
        return new Person(100,"spring");
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Person frank() {
        return new Person(100,"frank");
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Person jones() {
        return new Person(100,"jones");
    }
}
