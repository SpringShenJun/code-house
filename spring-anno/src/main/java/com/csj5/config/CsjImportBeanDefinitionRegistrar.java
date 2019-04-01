package com.csj5.config;

import com.csj5.bean.Mouse;
import com.csj5.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

//容器中导入组件基本都底层都是用这种方式(模块化管理)
public class CsjImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /*
    AnnotationMetadata 当前类的注解信息(这个类加了什么注解什么信息)
    BeanDefinitionRegistry ：BeanDefinition注册类
        把所有需要添加到容器中的bean加入
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {

        boolean definition = registry.containsBeanDefinition(Mouse.class.getName());
        //如果Mouse存在ioc容器中，那么把pig实例，加入到容器
        if (definition) {
            //对于我们要注册的bean，要对新的bean进行封装 想往容器中添加bean都是通过RootBeanDefinition
            registry.registerBeanDefinition("pig", new RootBeanDefinition(Pig.class));
        }
    }
}
