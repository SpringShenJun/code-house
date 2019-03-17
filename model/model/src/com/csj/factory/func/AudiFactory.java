package com.csj.factory.func;

import com.csj.factory.Audi;
import com.csj.factory.Car;

//
public class AudiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
