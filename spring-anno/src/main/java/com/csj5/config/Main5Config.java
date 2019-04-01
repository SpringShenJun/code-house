package com.csj5.config;

import com.csj.Person;
import com.csj5.bean.Cat;
import com.csj5.bean.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Import
 */

@Configuration
@Import(value = {Dog.class, Cat.class, CsjImportSelector.class, CsjImportBeanDefinitionRegistrar.class})
public class Main5Config {


    /*
     *给容器中注册组件的方式
     * 1.@Bean:导入第三方的类或包的组件，比如Person为第三方的类，需要在我们的ioc容器中使用
     * 2.包扫描+组件的标注注解(@ComponentScan @Controller @Service....),一般是针对我们自己写的类.
     * 3.@Import:能够快速给容器中导入组件。和Bean相比，@Bean相对简单粗暴
     *  a，@Import(要导入到容器中的组件)：容器会自动注册这个组件，bean的id为全类名(com.csj5.bean.Dog)
     *  b.ImportSelector是一个 接口，返回需要导入到容器的组件的去按类名数组
     *  c.ImportBeanDefinitionRegistrar:可以手动添加组件到ioc容器，所有bean的注册可以使用BeanDefinitionRegistry
     *      实现ImportBeanDefinitionRegistrar接口即可
     * 4.使用Spring提供的FactoryBean(工厂Bean实现)进行注册
     */
    //容器启动时初始化person的bean实例
    @Bean
    public Person sunday() {
        return new Person(50, "sunday");
    }
    @Bean
    public FactoryBean csjFactoryBean() {
        return  new CsjFactoryBean();
    }


}
