package com.csj.factory.func;

import com.csj.factory.Car;

public class FactoryFunctionTest {

    public static void main(String[] args) {

        //工厂方法模式
        //各个产品的生产商，都拥有各自的工厂。
        //每个品牌的高科技程度是不一样的。
        //需要Audi车
        Car audi = new AudiFactory().getCar();
        System.out.println("car = " + audi.getCarName());
        Car benz = new BenzFactory().getCar();
        System.out.println("benz = " + benz.getCarName());
    }
}
