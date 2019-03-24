package com.csj1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj1Test {



    @Test
    public void test01() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main1Config.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
