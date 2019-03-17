package com.csj.factory.abstr;

import com.csj.factory.Bmw;
import com.csj.factory.Car;

public class BmwFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
