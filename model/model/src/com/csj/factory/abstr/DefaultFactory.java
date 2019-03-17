package com.csj.factory.abstr;

import com.csj.factory.Car;

public class DefaultFactory extends AbstractFactory{

    private AudiFactory defaultFactory = new AudiFactory();

    @Override
    public Car getCar() {
        return defaultFactory.getCar();
    }
}
