package com.csj6;

import com.csj6.config.MainConfigOfLiveCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj6Test {


    @Test
    public void test01() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLiveCycle.class);

        System.out.println("ioc创建完成..");

        context.close();


//            String[] names = context.getBeanDefinitionNames();
//            for (String name : names) {
//                System.out.println("name = " + name);
//            }

    }
}
