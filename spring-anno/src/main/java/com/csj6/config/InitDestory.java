package com.csj6.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitDestory implements InitializingBean, DisposableBean {

    public InitDestory() {
        System.out.println("InitDestory constructor...");
    }
    //bean销毁时调用
    public void destroy() throws Exception {

        System.out.println("InitDestory destroy..");
    }

    //bean属性赋值和初始化调用
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitDestory afterPropertiesSet..");

    }
}
