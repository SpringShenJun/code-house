package com.csj;

import java.io.Serializable;

public class Person implements Serializable {

    private Integer age;
    private String name;

    public Person() {
        System.out.println("Person() ");
    }

    public Person(Integer age, String name) {
        System.out.println("age = " + age + "name = " + name);
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
