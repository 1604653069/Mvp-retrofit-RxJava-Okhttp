package com.retrofit.model;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Address> addressList;

    public Person() {
    }

    public Person(String name, int age, List<Address> addressList) {
        this.name = name;
        this.age = age;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addressList=" + addressList +
                '}';
    }
}
