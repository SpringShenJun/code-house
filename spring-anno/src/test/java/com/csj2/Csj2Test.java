package com.csj2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj2Test {



    @Test
    public void test01() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main2Config.class);



        //从容器中取两次bean，看是否为同一个实例
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");

        //默认person1 = person2
        System.out.println(person1 == person2);


    }
}
