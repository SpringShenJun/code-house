package com.csj.factory.simple;

import com.csj.factory.Audi;
import com.csj.factory.Benz;
import com.csj.factory.Bmw;
import com.csj.factory.Car;

public class SimpleFactory {

    //实现统一管理，专业化管理
    //如果没有工厂模式，可以说没有执行标准。
    //买到的是三五产品还是什么，是让用户不放心的。
    //码农就是执行标准的人
    //系统架构师：制定标准的人。
    public Car getCar(String name) {

        if("Bmw".equals(name)) {
            return new Bmw();
        } else if ("Audi".equals(name)) {
            return new Audi();
        } else if ("Benz".equals(name)) {
            return new Benz();
        }
        throw new IllegalArgumentException("产品不存在");
    }


}
