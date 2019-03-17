package com.csj.singleton;

//饿汉式(恶汉式)
public class Singleton02 {

    //    三部曲
    //1.私有构造方法,不让外界进行创建对象。
    private Singleton02() {
    }

    //2.静态变量实例
    private static Singleton02 singleton = new Singleton02();


    //3.通过提供一个静态方法来获取我们的单例
    //该单例模式是饿汉式，及加载该类字节码的时候该单例就已经被创建。
    public static Singleton02 getInstance() {

        return singleton;
    }
}
