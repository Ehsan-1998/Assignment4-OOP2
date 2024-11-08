package com.example.ZooApplication.Model;

public class Tiger extends  BigCat {
    private final int weight;

    public Tiger(String name, int age, int weight) {
        super(name, age); // Calling the constructor of the Animal superclass
        this.weight = weight;
    }

    // Getter for weight
    public int getWeight() {
        return weight;
    }
}
