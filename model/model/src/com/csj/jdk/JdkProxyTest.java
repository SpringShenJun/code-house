package com.csj.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 > 满足代理模式应用场景的三个必要条件(穷取法)
 > 1.两个角色：执行者、被代理对象
 > 2.注重过程，必须要做，被代理对象没时间做或者不想做
 > 3.执行者必须拿到被代理对象的引用
 */
class JdkProxyTest {

    public static void main(String[] args) {

        Person coder = new Coder();
        Person proxy = new MeiPo().getInstance(coder);
        proxy.findLove();
        System.out.println("proxy = " + proxy.getClass());


//        new MeiPo().getInstance(new Coder()).findLove();
        /*
            原理：
            1.拿到被代理类对象的引用，然后获取它的接口
            2.jdk代理重新生成一个类，同时实现我们被代理类对象的接口
            3.被动态代理对象的引用也拿到了
            4.重新动态一个class字节码
            5.编译(classLoader进jvm)

         */
        //----也可以打印jdk动态代理生成的类信息
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{
                Person.class
        });


        try {
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write($Proxy0s);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

