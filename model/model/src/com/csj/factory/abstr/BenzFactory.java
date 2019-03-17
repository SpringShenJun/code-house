package com.csj.factory.abstr;

import com.csj.factory.Benz;
import com.csj.factory.Car;

public class BenzFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
