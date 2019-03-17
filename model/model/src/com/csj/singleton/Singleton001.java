package com.csj.singleton;

//懒汉式单例 保证线程安全
public class Singleton001 {

    //    三部曲
    //1.私有构造方法,不让外界进行创建对象。
    private Singleton001() {
    }

    //2.声明一个静态变量保存单例的引用
    private static volatile Singleton001 singleton = null;


    //3.通过提供一个静态方法来获取我们的单例
    //在多线程环境使用在该单例实现是线程安全的
    //添加了synchronized的悲观锁修饰，即一次只有一个线程能访问该方法。抑制住了我们的性能消耗，造成资源的浪费
    public static synchronized Singleton001 getInstance() {

        if (singleton == null) {

            singleton = new Singleton001();
        }
        return singleton;
    }
}
