package com.example.ZooApplication.Model;

public class Lion extends BigCat {
    private int maneSize;

    public Lion(String name, int age, String sex, double weight, int maneSize) {
        super(name, age, sex, weight);
        this.maneSize = maneSize;
    }

    public int getManeSize() {
        return maneSize;
    }

    public void setManeSize(int maneSize) {
        this.maneSize = maneSize;
    }
}

