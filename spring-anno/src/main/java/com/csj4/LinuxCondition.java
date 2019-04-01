package com.csj4;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//LinuxCondition
public class LinuxCondition implements Condition{

    /*
     *
     * ConditionContext: 判断条件的上下文环境
     *annotatedTypeMetadata: 注解的信息
     *
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取当前环境变量（包括我们操作系统是win还是linux）
        Environment environment = conditionContext.getEnvironment();
        String environmentProperty = environment.getProperty("os.name");
        System.out.println("environmentProperty = " + environmentProperty);
        if (environmentProperty.contains("Linux")) {
            return true;
        }

        //获取到ioc容器当前正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        return false;
    }
}
