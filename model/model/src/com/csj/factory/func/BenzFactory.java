package com.csj.factory.func;

import com.csj.factory.Benz;
import com.csj.factory.Car;

public class BenzFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
