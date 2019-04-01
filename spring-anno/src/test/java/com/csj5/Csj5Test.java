package com.csj5;

import com.csj5.config.CsjFactoryBean;
import com.csj5.config.Main5Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Csj5Test {


    @Test
    public void test01() {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(Main5Config.class);
            String[] names = context.getBeanDefinitionNames();
            for (String name : names) {
                System.out.println("name = " + name);
            }
            CsjFactoryBean factoryBean = (CsjFactoryBean) context.getBean("&csjFactoryBean");

            System.out.println("factoryBean.getObject().getClass() = " + factoryBean.getObject().getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
