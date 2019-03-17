package com.csj.factory.func;

import com.csj.factory.Car;

//工厂接口，就定义了所有工厂的标准
public interface CarFactory {

    //符合通用的标准
    //尾气排放
    //安全带安全气囊的标配
    //轮胎的耐磨指数等等
    public Car getCar();
}
