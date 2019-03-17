package com.csj.singleton;

//懒汉式单例 静态内部类
public class Singleton00001 {

    //    三部曲
    //1.私有构造方法,不让外界进行创建对象。
    private Singleton00001() {
    }

    //2.静态内部类
    private static class LazyHolder {

        //防止内部误操作，不小心对其使用了代理或者其他的情况，final修饰，不允许改变
        private static final Singleton00001 INSTANCE = new Singleton00001();
    }


    //3.通过提供一个静态方法来获取我们的单例
    public static  Singleton00001 getInstance() {

        return LazyHolder.INSTANCE;
    }
}
