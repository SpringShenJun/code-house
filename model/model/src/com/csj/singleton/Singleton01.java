package com.csj.singleton;

//懒汉式单例类， 线程不安全 在第一次调用的时候实例化自己
public class Singleton01 {

    //    三部曲
    //1.私有构造方法,不让外界进行创建对象。
    private Singleton01() {
    }

    //2.声明一个静态变量保存单例的引用
    private static  Singleton01 singleton = null;


    //3.通过提供一个静态方法来获取我们的单例
    //在多线程环境使用在该单例实现是不安全的，不推荐使用此写法
    public static Singleton01 getInstance() {

        if (singleton == null) {

            singleton = new Singleton01();
        }
        return singleton;
    }
}
