package com.csj.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeimo implements MethodInterceptor{


    public Object getInstance(String className) throws Exception{

        //用过反射机制，进行实例化
        Class<?> forName = Class.forName(className);

        Enhancer enhancer = new Enhancer();
        //设置父类为谁
        //这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(forName);

        //回调我们的方法intercept(...)
        enhancer.setCallback(this);
        //第一步：生成源代码
        //第二步：编译生成class文件
        //第三步：classloader进jvm
        return enhancer.create();
    }



    /**
     * 同样是做了字节码重组这样一件事情
     * 对于使用 api的用户来说，是无感知的
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib媒婆启动");
        //调用的super的方法
        //这个o的引用是cglib给我们new出来的
        //cglib在new出来以后的对象是被代理对象的子类(继承了我们写的那个类)
        //在new子类之前，实际上默认先调用了super()方法的
        //new了子类的同时，必须先new出来父类，这就相当于简介的持有了我们父类的引用
        //子类重写了父类的所有的方法
        //我们改变子类对象的某些属性，是可以间接的操作父类的属性
        methodProxy.invokeSuper(o, objects);
        System.out.println("cglib媒婆匹配成功");
        return null;
    }
}
