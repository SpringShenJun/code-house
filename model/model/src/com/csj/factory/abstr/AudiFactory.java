package com.csj.factory.abstr;

import com.csj.factory.Audi;
import com.csj.factory.Car;

//
public class AudiFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
