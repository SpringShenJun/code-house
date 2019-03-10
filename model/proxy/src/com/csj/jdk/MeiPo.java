package com.csj.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒婆
 */
 class MeiPo implements InvocationHandler {

    private Person person;

    public Person getInstance(Person person) {
        this.person = person;
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("媒婆来了，要获取相应的资料信息");
        this.person.findLove();
        System.out.println("获取资料信息1完毕");
        return null;
    }
}
