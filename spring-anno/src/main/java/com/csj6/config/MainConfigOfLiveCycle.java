package com.csj6.config;

import com.csj6.bean.Bike;
import com.csj6.bean.Jeep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 生命周期
 */
@Configuration
@ComponentScan(value = "com.csj6.config")
public class MainConfigOfLiveCycle {

    /*
    指容器
    bean的生命周期指bean创建-->初始化-->销毁的过程


    1.可以通过xml的配置方式进行 init-method的设置或者注解的方式
    2.实现InitializingBean 接口的afterPropertiesSet(),当beanFactory创建好对象，且把bean所有属性设置好
        之后，会调用这个方法，相当于初始化方法
      实现DisposableBean的destory()方法，当bean销毁时，会把单实例bean销毁
    3. JSR250提供的标准,bean创建完成之后会执行初始化PostConstuctor
        close的时候会执行PreDestroy bean的移除之前进行清理

    4.BeanPostProcessorse(bean的后置处理器) 在bean初始化之前调用进行拦截，在bean初始化前后进行一些处理工作
        实现接口BeanPostProcessorsr.针对每一个bean

        bike constructor
        postProcessBeforeInitialization.. beanName = bike
        init..bike
        postProcessAfterInitialization .. beanName = bike
 */

    //    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike() {
        return new Bike();
    }


    @Bean()
    public Jeep jeep() {
        return new Jeep();
    }
}
