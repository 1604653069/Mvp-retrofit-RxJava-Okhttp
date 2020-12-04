package com.retrofit.model;

public class Address {
    private String provice;
    private String city;

    public Address() {
    }

    public Address(String provice, String city) {
        this.provice = provice;
        this.city = city;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
