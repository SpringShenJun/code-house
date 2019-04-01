package com.csj6.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsjBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //返回一个对象(传过来的对象)
        //在初始化方法调用之前进行后置处理工作
        //init之前执行
        System.out.println("postProcessBeforeInitialization.. beanName = " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization .. beanName = " + beanName);
        return bean;
    }

}
