package com.example.ZooApplication.Model;

public class Lion extends BigCat{
    private final int weight;
    private final int maneSize;

    public Lion(String name, int age, int weight, int maneSize) {
        super(name, age); // Calling the constructor of the Animal superclass
        this.weight = weight;
        this.maneSize = maneSize;
    }

    // Getters for weight and maneSize
    public int getWeight() {
        return weight;
    }

    public int getManeSize() {
        return maneSize;
    }
}
