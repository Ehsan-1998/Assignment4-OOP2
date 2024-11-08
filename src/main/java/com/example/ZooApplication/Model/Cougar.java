package com.example.ZooApplication.Model;

public class Cougar extends BigCat {
    private final int weight;

    public Cougar(String name, int age, int weight) {
        super(name, age);
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }
}
