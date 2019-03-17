package com.csj.singleton;

//懒汉式单例 双重锁检查
public class Singleton0001 {

    //    三部曲
    //1.私有构造方法,不让外界进行创建对象。
    private Singleton0001() {
    }

    //2.声明一个静态变量保存单例的引用
    private static volatile Singleton0001 singleton = null;


    //3.通过提供一个静态方法来获取我们的单例
    //保证多线程环境下的另一种实现方式，双重锁检查
    public static  Singleton0001 getInstance() {

        if (singleton == null) {

            synchronized (Singleton0001.class) {

                if (singleton == null) {

                    singleton = new Singleton0001();
                }
            }
        }
        return singleton;
    }
}
