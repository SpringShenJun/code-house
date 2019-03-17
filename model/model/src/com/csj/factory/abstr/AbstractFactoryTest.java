package com.csj.factory.abstr;

import com.csj.factory.Car;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        //默认实现
        DefaultFactory df = new DefaultFactory();
        System.out.println(" cat is " + df.getCar());
        Car benz = df.getCar("Benz");
        System.out.println(" cat is " + benz);

    }
}
