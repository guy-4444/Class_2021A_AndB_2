package com.classy.class_2021a_andb_2;

public class Car {

    private String mode = "";
    private int wheels = 0;

    public Car() { }

    public Car(String mode, int wheels) {
        this.mode = mode;
        this.wheels = wheels;
    }

    public String getMode() {
        return mode;
    }

    public Car setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public int getWheels() {
        return wheels;
    }

    public Car setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }
}
