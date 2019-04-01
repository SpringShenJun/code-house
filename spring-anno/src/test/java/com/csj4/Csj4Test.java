package com.csj4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj4Test {



    @Test
    public void test01() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main4Config.class);
        System.out.println("spring容器启动完成");
        System.out.println("执行完毕");

    }
}
