package com.wang.learnjava;


public class Person {

    private String name;

    private  String money;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
}