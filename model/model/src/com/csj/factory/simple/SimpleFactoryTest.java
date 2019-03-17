package com.csj.factory.simple;

import com.csj.factory.Car;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        //这边就是我们的消费者,怎么生产不关心
        SimpleFactory simpleFactory = new SimpleFactory();
        Car benz = simpleFactory.getCar("Benz");
        System.out.println("car = " + benz.getCarName());
        Car audi= simpleFactory.getCar("Audi");
        System.out.println("car = " + audi.getCarName());

    }
}
