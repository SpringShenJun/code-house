package com.csj.factory.abstr;

import com.csj.factory.Car;

public abstract class AbstractFactory {

    //谁实现谁用。protected
    protected abstract Car getCar();

    public Car getCar(String name) {

        if("Bmw".equals(name)) {
            return new BmwFactory().getCar();
        } else if ("Audi".equals(name)) {
            return new AudiFactory().getCar();
        } else if ("Benz".equals(name)) {
            return new BenzFactory().getCar();
        }
        throw new IllegalArgumentException("产品不存在");
    }
}
