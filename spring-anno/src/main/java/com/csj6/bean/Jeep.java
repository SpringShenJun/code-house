package com.csj6.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Jeep {

    public Jeep() {
        System.out.println("jeep constructor");
    }

    @PostConstruct
    public void init(){

        System.out.println("jeep PostConstruct");

    }

    @PreDestroy
    public void destory(){
        System.out.println("jeep PreDestroy");


    }
}
