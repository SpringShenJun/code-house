package com.csj.manual;

import java.lang.reflect.Method;

/**
 * 业务处理类
 */
public class ManualMeipo implements ManualInvocationHandler{



    private Person person;

    public Person getInstance(Person person) throws Exception {
        this.person = person;
        return (Person) ManualProxy.newProxyInstance( new ManualClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        System.out.println("ManualMeipo-->");
        this.person.findLove();
        System.out.println("findLove匹配完毕--》");
        return null;
    }
}
