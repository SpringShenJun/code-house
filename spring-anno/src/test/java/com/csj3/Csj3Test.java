package com.csj3;

import csj3.Main3Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj3Test {



    @Test
    public void test01() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main3Config.class);
        System.out.println("spring容器启动完成");
        Object person = context.getBean("person");
        System.out.println("执行完毕");

    }
}
