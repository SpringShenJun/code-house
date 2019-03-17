package com.csj.factory.func;

import com.csj.factory.Bmw;
import com.csj.factory.Car;

public class BmwFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
