package com.csj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        //早期的时候spring是通过xml配置来使用的
        //把beans.xml配置的类加载到spring容器中
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //通过注解配置的方法从ioc容器中获得bean
//        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        //从容器中获取bean
        Person person = context.getBean(Person.class);
        System.out.println(person);

        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {

            System.out.println(name);
        }
    }
}
