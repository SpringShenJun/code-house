package com.csj5.config;

import com.csj5.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

public class CsjFactoryBean implements FactoryBean<Monkey> {
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    public Class<?> getObjectType() {
        return Monkey.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
